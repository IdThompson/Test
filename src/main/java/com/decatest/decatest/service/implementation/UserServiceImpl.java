package com.decatest.decatest.service.implementation;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import com.decatest.decatest.repository.UserRepository;
import com.decatest.decatest.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User saveUser(UserRequestDto request) {
        return userRepository.save(User.builder()
                        .age(request.getAge())
                        .name(request.getName())
                .build());
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public boolean updateUserById(Long userId, UserRequestDto request) {
        User userToBeUpDated = this.findUserById(userId);
        userToBeUpDated.setAge(request.getAge());
        userToBeUpDated.setName(request.getName());
        userRepository.save(userToBeUpDated);
        return true;
    }

    @Override
    public boolean deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }
}
