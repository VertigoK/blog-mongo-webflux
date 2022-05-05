package kevin.study.blogmongowebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import kevin.study.blogmongowebflux.domain.Board;
import kevin.study.blogmongowebflux.service.BoardService;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Mono<Board>> save(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.saveBoard(board), HttpStatus.OK);
    }

    @PutMapping("/board/{id}")
    public ResponseEntity<Mono<Board>> updateById(@PathVariable("id") Long id,
                                                  @RequestBody Board board) {
        return new ResponseEntity<>(boardService.updateBoard(id, board), HttpStatus.OK);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<Mono<Board>> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.deleteBoard(id), HttpStatus.OK);
    }
}
