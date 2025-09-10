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

    public void save(UserDto dto) {
        User user = modelMapper.map(dto, User.class);
        userRepository.save(user);
    }
}
