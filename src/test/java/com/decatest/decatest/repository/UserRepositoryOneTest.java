package com.decatest.decatest.repository;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRepositoryOneTest {

    //JUnit 5 aka Jupiter ##

    //Unit Test
//    You should not User @SpringBootTest
//    You should have test Resource
    // return void and should be public
    // WhatYouWantToTest_ExpectedResult (Naming convention)

    @Mock
     private UserRepository userRepository;

     private UserRequestDto userRequestDto;
     private User user;

    //CRUD
    @BeforeEach
    void setUp() {
        userRequestDto = new UserRequestDto(1L,"ada",19 );
        user = new User(
                userRequestDto.getId(),
                userRequestDto.getName(),
                userRequestDto.getAge()
        );
    }

    @Test
    public void testSaveUser_shouldReturnUser(){
        when(userRepository.save(user)).thenReturn(user);

        String expectedName = "ada";
        Integer expectedAge = 19;

        assertEquals(expectedName,userRepository.save(user).getName());
        assertEquals(expectedAge,userRepository.save(user).getAge());
    }

    @Test
    public void findUserById_shouldReturnTheUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        String expectedName = "ada";
        Integer expectedAge = 19;
        assertTrue(userRepository.findById(1L).isPresent());
        assertEquals(expectedAge,userRepository.findById(1L).get().getAge());
        assertEquals(expectedName,userRepository.findById(1L).get().getName());
    }
}