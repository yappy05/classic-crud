package practice.classic_crud.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.User;
import practice.classic_crud.model.dto.UserDto;
import practice.classic_crud.model.dto.UserProfileDto;
import practice.classic_crud.repo.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserProfileService userProfileService;
    private final ModelMapper modelMapper;

    public User save(UserDto dto) {
        User user = modelMapper.map(dto, User.class);
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("не удалось найти пользователя"));
    }

    public User update(Long id, UserDto dto) {
        User user = findUserById(id);
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    public User updateProfile(Long id, UserProfileDto dto) {
        User user = findUserById(id);
        userProfileService.update(user.getProfile().getId(), dto);
        return user;
    }

//    public List<Post> findPostsByUserId(Long id) {}
}
