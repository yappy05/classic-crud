package practice.classic_crud.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.classic_crud.model.User;
import practice.classic_crud.model.dto.UserDto;
import practice.classic_crud.repo.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public User save(UserDto dto) {
        User user = modelMapper.map(dto, User.class);
        return userRepository.save(user);
    }
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return user;
    }
}
