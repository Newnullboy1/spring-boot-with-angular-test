package com.example.demo.user.model;

import com.example.demo.UtilTestData;
import com.example.demo.user.UserEntity;
import com.example.demo.user.model.response.UserResponse;
import com.example.demo.user.model.wrapper.UserResponseList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    UtilTestData utilTestData;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("555")
    void getUsers() {

        List<UserResponse> userResponses = userMapper.toUserResponse(utilTestData.generateUserMockData());

        when(userService.getUsers()).thenReturn(userResponses);

        ResponseEntity<UserResponseList> result = testRestTemplate.getForEntity("/user",UserResponseList.class);


        System.out.println(result.getBody());

        assertTrue(result.hasBody());
//        assertEquals("User1", Objects.requireNonNull(result.getBody()).getUsers().get(1).getName());
    }

    @Test
    void addUser() {
    }

    @Test
    void findUserByName() {
    }
}