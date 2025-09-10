package practice.classic_crud.contollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.classic_crud.model.User;
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


    //User

    @PostMapping
    public User save(@RequestBody UserDto dto) {
        return userService.save(dto);
    }

    @GetMapping("by-id/{id}")
    User findById (@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("update-user/{id}")
    public User updateUsername(@PathVariable Long id, @RequestBody UserDto user) {
        return userService.update(id, user);
    }


    //Profile

    @PostMapping("add-profile")
    public UserProfile addProfile(@RequestBody UserProfileDto dto) {
        return userProfileService.save(dto);
    }

    @PutMapping("update-profile/{id}")
    public User updateProfile(@PathVariable("id") Long id, @RequestBody UserProfileDto dto) {
        return userService.updateProfile(id, dto);
    }
}

