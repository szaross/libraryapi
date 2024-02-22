package com.library.api.service;

import com.library.api.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(long id);
}
