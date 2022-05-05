package uniflow.blogmongowebflux.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uniflow.blogmongowebflux.domain.Board;
import uniflow.blogmongowebflux.repository.BoardRepository;

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
