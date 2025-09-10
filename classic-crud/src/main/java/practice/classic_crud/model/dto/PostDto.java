package practice.classic_crud.model.dto;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String content;
    private Long authorId;
}
