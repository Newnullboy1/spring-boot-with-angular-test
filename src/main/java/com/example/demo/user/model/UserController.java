package com.example.demo.user.model;

import com.example.demo.user.model.request.UserAddRequest;
import com.example.demo.user.model.request.UserFNameRequest;
import com.example.demo.user.model.response.UserResponse;
import com.example.demo.user.model.wrapper.UserResponseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    //    @GetMapping
//    public ResponseEntity<List<UserResponse>> getUsers(){
//        return ResponseEntity.ok(userService.getUsers());
//    }
    @GetMapping
    public ResponseEntity<UserResponseList> getUsers() {
        UserResponseList userResponseList = new UserResponseList();
        userResponseList.setUsers(userService.getUsers());
        return ResponseEntity.ok(userResponseList);
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserAddRequest request) {
        return ResponseEntity.ok(userService.addUser(request));
    }

    @PostMapping("/find/name")
    public ResponseEntity<UserResponse> findUserByName(@RequestBody UserFNameRequest request) {
        return ResponseEntity.ok(userService.findUserByFName(request.getName()));
    }

}
