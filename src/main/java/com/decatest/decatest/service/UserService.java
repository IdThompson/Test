package com.decatest.decatest.service;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;

public interface UserService {

    User saveUser(UserRequestDto request);

    User findUserById(Long userId);

    boolean updateUserById(Long userId, UserRequestDto request);

    boolean deleteUserById(Long userId);

}
