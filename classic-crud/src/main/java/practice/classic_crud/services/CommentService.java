package practice.classic_crud.services;

import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import practice.classic_crud.model.Comment;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.User;
import practice.classic_crud.model.dto.CommentDto;
import practice.classic_crud.repo.CommentRepository;
import practice.classic_crud.repo.PostRepository;

@Service
@AllArgsConstructor
public class CommentService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Comment save(CommentDto dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());
        User user = userService.findUserById(dto.getAuthorId());
        Post post = postRepository.findById(dto.getPostId()).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        comment.setAuthor(user);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Comment not found"));
    }
}
