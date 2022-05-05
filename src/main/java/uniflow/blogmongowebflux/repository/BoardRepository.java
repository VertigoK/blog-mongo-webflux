package uniflow.blogmongowebflux.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uniflow.blogmongowebflux.domain.Board;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Repository
public class BoardRepository {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    public Mono<Board> insertBoard(Board board) {
        return reactiveMongoTemplate.insert(board, "board");
    }

    public Flux<Board> findBoards() {
        return reactiveMongoTemplate.findAll(Board.class).switchIfEmpty(Flux.empty());
    }

    public Mono<Board> findBoardById(Long id) {
        return reactiveMongoTemplate.findById(id, Board.class).switchIfEmpty(Mono.empty());
    }

    public Mono<Board> updateBoardById(Long id, Board board) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("title", board.getTitle());
        update.set("content", board.getContent());
        update.set("updatedDateTime", LocalDateTime.now());
        return reactiveMongoTemplate.findAndModify(query, update, options().returnNew(true), Board.class);
    }

    public Mono<Board> deleteBoardById(Long id) {
        Mono<Board> dbBoard = findBoardById(id);
        if (Objects.isNull(dbBoard)) {
            return Mono.empty();
        }
        return dbBoard
                .switchIfEmpty(Mono.empty())
                .filter(Objects::nonNull)
                .flatMap(boardToDelete ->
                        reactiveMongoTemplate.remove(boardToDelete).then(Mono.just(boardToDelete)));
    }
}
