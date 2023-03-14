package com.decatest.decatest.controller;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import static org.hamcrest.Matchers.is;
import com.decatest.decatest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserRequestDto userRequestDto;
    private User user;

    @Test
    void shouldSaveUser() throws Exception {
        userRequestDto = new UserRequestDto(1L,"joy",20 );
        this.user = new User(
                userRequestDto.getId(),
                userRequestDto.getName(),
                userRequestDto.getAge()
        );

        given(userService.saveUser(userRequestDto)).willReturn(user);

        mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(userRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.name", is("joy")));

        verify(userService).saveUser(userRequestDto);
    }

    @Test
    void shouldGetUser() throws Exception {
        User fetchedUser = new User(1L, "joy", 20);
        given(userService.findUserById(1L)).willReturn(fetchedUser);

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age", is(20)))
                .andExpect(jsonPath("$.name", is("joy")));

        verify(userService).findUserById(1L);
    }

    @Test
    void shouldDeleteUser() throws Exception {
        given(userService.deleteUserById(1L)).willReturn(true);

        mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(userService).deleteUserById(1L);
    }

    private String toJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
