package practice.classic_crud.model.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private String firstName;
    private String lastName;
    private String bio;
    private Long userId;
}
