package practice.classic_crud.contollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.dto.PostDto;
import practice.classic_crud.model.dto.PostUpdateRequest;
import practice.classic_crud.model.dto.TagDto;
import practice.classic_crud.services.PostService;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("by-id/{id}")
    Post findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }
    @PostMapping("add")
    Post save(@RequestBody PostDto dto) {
        return postService.save(dto);
    }
    @PostMapping("/add-tag/{id}")
    Post addNewTag(@PathVariable Long id, @RequestBody TagDto dto) {
        return postService.addNewTag(id, dto);
    }
    @PutMapping("/update")
    Post update(@RequestBody PostUpdateRequest dto) {
        return postService.update(dto);
    }
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
