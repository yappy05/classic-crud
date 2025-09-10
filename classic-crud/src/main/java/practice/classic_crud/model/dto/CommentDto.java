package practice.classic_crud.model.dto;

import lombok.Data;
import practice.classic_crud.model.Comment;

@Data
public class CommentDto {
    private Long id;
    private String text;
    private Long postId;
    private Long authorId;
    private String authorName;

//    // Правильный конструктор (без возвращаемого типа)
//    public CommentDto(Comment comment) {
//        this.id = comment.getId();
//        this.text = comment.getText();
//        this.postId = comment.getPost().getId();
//        this.authorId = comment.getAuthor().getId();
//        this.authorName = comment.getAuthor().getUsername();
//    }
}
