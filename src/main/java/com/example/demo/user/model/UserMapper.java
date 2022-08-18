package com.example.demo.user.model;

import com.example.demo.user.UserEntity;
import com.example.demo.user.model.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(UserEntity user);

    List<UserResponse> toUserResponse(List<UserEntity> users);

}
