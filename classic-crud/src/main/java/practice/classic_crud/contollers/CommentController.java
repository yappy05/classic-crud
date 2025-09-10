package practice.classic_crud.contollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.classic_crud.model.Comment;
import practice.classic_crud.model.dto.CommentDto;
import practice.classic_crud.services.CommentService;

@RestController
@AllArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("add")
    public Comment save(@RequestBody CommentDto dto) {
        return commentService.save(dto);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
    @GetMapping("by-id/{id}")
    Comment findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }
}
