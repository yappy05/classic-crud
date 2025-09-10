package practice.classic_crud.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.Tag;
import practice.classic_crud.model.User;
import practice.classic_crud.model.dto.PostDto;
import practice.classic_crud.model.dto.PostUpdateRequest;
import practice.classic_crud.model.dto.TagDto;
import practice.classic_crud.repo.PostRepository;
import practice.classic_crud.repo.TagRepository;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final TagService tagService;

    public Post save(PostDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        User author = userService.findUserById(dto.getAuthorId());
        post.setAuthor(author);
        return postRepository.save(post);
    }

    public Post update(PostUpdateRequest dto) {
        Post post = postRepository.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return postRepository.save(post);
    }

    public Post addNewTag(Long id,TagDto dto) {
        System.out.println(id);
        System.out.println(dto);
        tagService.addTagToPost(id, dto);
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
        postRepository.delete(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }
}
