package com.library.api.service.impl;

import com.library.api.dto.UserDto;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.models.User;
import com.library.api.repositories.UserRepository;
import com.library.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = User.builder()
                .first_name(userDto.getFirst_name())
                .last_name(userDto.getLast_name())
                .email(userDto.getEmail())
                .build();
        User saved = userRepository.save(user);
        return UserDto.UserDtoBuilder.fromUser(saved);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("User not found"));
        return UserDto.UserDtoBuilder.fromUser(user);
    }
}
