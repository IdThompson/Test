package com.decatest.decatest.controller;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import com.decatest.decatest.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    //CRUD

    @PostMapping(path = "save")
    public User registerUser(@RequestBody @Valid UserRequestDto request) {
        User userResponse = userService.saveUser(request);
        return userResponse;
    }

    @GetMapping(path = "{userId}")
    public User fetchUser(@PathVariable Long userId) {
        User userResponse = userService.findUserById(userId);
        return userResponse;
    }

    @DeleteMapping(path = "{userId}")
    public boolean deleteUserById(@PathVariable Long userId) {
        return userService.deleteUserById(userId);
    }




}
