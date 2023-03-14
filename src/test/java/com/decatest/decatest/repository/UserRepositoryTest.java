package com.decatest.decatest.repository;

import com.decatest.decatest.dto.request.UserRequestDto;
import com.decatest.decatest.model.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    //Point of using @DataJpaTest -- mimic exact persistence

    //RollBack
    //EntityManager

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    private UserRequestDto userRequestDto;

    private User user;

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
    public void findUserBy_shouldReturnUser() {


    }
}