package uniflow.blogmongowebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import uniflow.blogmongowebflux.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //메인 화면
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //글 전체 목록 보기 화면
    @GetMapping("/board")
    public String boardList(Model model) {
        IReactiveDataDriverContextVariable reactiveDataDriverMode =
                new ReactiveDataDriverContextVariable(boardService.getAllBoards(), 1);
        model.addAttribute("boards", reactiveDataDriverMode);
        return "board/boardList";
    }

    //글 쓰기 화면
    @GetMapping("/board/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }

    //글 상세 보기 화면
    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model) {
        IReactiveDataDriverContextVariable reactiveDataDriverMode =
                new ReactiveDataDriverContextVariable(boardService.getBoard(id).flux(), 1);
        model.addAttribute("boards", reactiveDataDriverMode);
        return "board/boardDetail";
    }

    //글 수정 화면
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable("id") Long id, Model model) {
        IReactiveDataDriverContextVariable reactiveDataDriverMode =
                new ReactiveDataDriverContextVariable(boardService.getBoard(id).flux(), 1);
        model.addAttribute("boards", reactiveDataDriverMode);
        return "board/updateForm";
    }

}
