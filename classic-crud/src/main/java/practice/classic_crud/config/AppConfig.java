package practice.classic_crud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.classic_crud.model.Post;
import practice.classic_crud.model.UserProfile;
import practice.classic_crud.model.dto.PostDto;
import practice.classic_crud.model.dto.UserProfileDto;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(UserProfileDto.class, UserProfile.class)
                .addMappings(mapper -> {
                    mapper.skip(UserProfile::setId);
                });

        return modelMapper;

    }
}