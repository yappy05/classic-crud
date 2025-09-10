package practice.classic_crud.contollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.classic_crud.model.UserProfile;
import practice.classic_crud.model.dto.UserDto;
import practice.classic_crud.model.dto.UserProfileDto;
import practice.classic_crud.services.UserProfileService;
import practice.classic_crud.services.UserService;

@RestController
@RequestMapping("/users") // Перенесите путь сюда
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserProfileService userProfileService;

    @PostMapping
    public void save(@RequestBody UserDto dto) {
        userService.save(dto);
    }

    @PostMapping("add-profile")
    public UserProfile addProfile(@RequestBody UserProfileDto dto) {
        return userProfileService.save(dto);
    }
}

