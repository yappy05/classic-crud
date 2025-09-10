package practice.classic_crud.services;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import practice.classic_crud.model.User;
import practice.classic_crud.model.UserProfile;
import practice.classic_crud.model.dto.UserProfileDto;
import practice.classic_crud.repo.UserProfileRepository;

@Service
@AllArgsConstructor
public class UserProfileService {
    private final UserService userService;
    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper;

    public UserProfile save(UserProfileDto dto) {
        User user = userService.findById(dto.getUserId());
        UserProfile profile = modelMapper.map(dto, UserProfile.class);
        profile.setUser(user);
        userProfileRepository.save(profile);
        return profile;
    }
}
