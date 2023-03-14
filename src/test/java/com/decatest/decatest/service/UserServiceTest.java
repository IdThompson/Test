package com.decatest.decatest.service;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserService userService;

    private UserRequestDto userRequestDto;
    private User user;

    @BeforeEach
    public void setup() {
        userRequestDto = new UserRequestDto(1L,"ada",19 );
        user = new User(
                userRequestDto.getId(),
                userRequestDto.getName(),
                userRequestDto.getAge()
        );
    }

    @Test
    public void testSaveUser() {
        when(userService.saveUser(userRequestDto)).thenReturn(user);
        User result = userService.saveUser(userRequestDto);
        verify(userService, times(1)).saveUser(userRequestDto);
        assertEquals(user, result);
    }

    @Test
    public void testFindUserById() {
        when(userService.findUserById(1L)).thenReturn(user);
        User result = userService.findUserById(1L);
        verify(userService, times(1)).findUserById(1L);
        assertEquals(user, result);
    }

    @Test
    public void testUpdateUserById() {
        when(userService.updateUserById(1L, userRequestDto)).thenReturn(true);
        boolean result = userService.updateUserById(1L, userRequestDto);
        verify(userService, times(1)).updateUserById(1L, userRequestDto);
        assertTrue(result);
    }

    @Test
    public void testDeleteUserById() {
        when(userService.deleteUserById(1L)).thenReturn(true);
        boolean result = userService.deleteUserById(1L);
        verify(userService, times(1)).deleteUserById(1L);
        assertTrue(result);
    }
}
