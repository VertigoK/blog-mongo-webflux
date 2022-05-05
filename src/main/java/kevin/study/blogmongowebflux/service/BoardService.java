package kevin.study.blogmongowebflux.service;

import kevin.study.blogmongowebflux.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import kevin.study.blogmongowebflux.domain.Board;

import java.time.LocalDateTime;

@Transactional
@AllArgsConstructor
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Mono<Board> saveBoard(Board board) {
        board.setCreatedDateTime(LocalDateTime.now());
        board.setUpdatedDateTime(LocalDateTime.now());
        return boardRepository.insertBoard(board);
    }

    public Flux<Board> getAllBoards() {
        return boardRepository.findBoards();
    }

    public Mono<Board> getBoard(Long id) {
        return boardRepository.findBoardById(id);
    }

    public Mono<Board> updateBoard(Long id, Board board) {
        return boardRepository.updateBoardById(id, board);
    }

    public Mono<Board> deleteBoard(Long id) {
        return boardRepository.deleteBoardById(id);
    }


}
