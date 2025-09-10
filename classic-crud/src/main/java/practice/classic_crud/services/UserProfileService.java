package practice.classic_crud.services;

import jakarta.persistence.EntityNotFoundException;
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
    private final UserProfileRepository userProfileRepository;
    private final ModelMapper modelMapper;

    public UserProfile save(UserProfileDto dto) {
        UserProfile profile = modelMapper.map(dto, UserProfile.class);
        return userProfileRepository.save(profile);
    }

    public UserProfile update(Long id, UserProfileDto dto) {
        UserProfile profile = userProfileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));

        profile.setFirstName(dto.getFirstName());
        profile.setLastName(dto.getLastName());
        profile.setBio(dto.getBio());

        return userProfileRepository.save(profile);
    }

    public UserProfile findById(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));
    }
}
