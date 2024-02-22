package com.library.api.controllers;

import com.library.api.dto.UserDto;
import com.library.api.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id){
        UserDto response = userService.getUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto response = userService.createUser(userDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
}
