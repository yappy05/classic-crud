package practice.classic_crud.model.dto;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private Long id;
    private String title;
    private String content;
}
