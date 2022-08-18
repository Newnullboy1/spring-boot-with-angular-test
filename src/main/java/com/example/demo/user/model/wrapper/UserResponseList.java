package com.example.demo.user.model.wrapper;

import com.example.demo.user.model.response.UserResponse;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
public class UserResponseList {

    private List<UserResponse> users;

}
