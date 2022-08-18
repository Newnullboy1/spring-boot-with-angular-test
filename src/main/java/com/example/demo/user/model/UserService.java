package com.example.demo.user.model;

import com.example.demo.PrimaryKeyGenerator;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import com.example.demo.user.exception.*;
import com.example.demo.user.model.request.UserAddRequest;
import com.example.demo.user.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PrimaryKeyGenerator primaryKeyGenerator;

    public List<UserResponse> getUsers() {

        List<UserEntity> users = userRepository.findAll();

        if (users.size() > 0) {
            return userMapper.toUserResponse(users);
        }

        throw new UserEmptyException("");
    }

    public UserResponse addUser(UserAddRequest request) {

        if (request.getName().isEmpty() || request.getName().equals("")) {
            throw new UserNameEmptyException("");
        }

        if (request.getEmail().isEmpty() || request.getEmail().equals("")){
            throw new UserEmailEmptyException("");
        }

        UserEntity entity = new UserEntity();
        entity.setId(primaryKeyGenerator.getPrimaryKey());
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());

        return userMapper.toUserResponse(userRepository.save(entity));
    }

    public UserResponse findUserByFName(String name) {
        Optional<UserEntity> userOpt = userRepository.findByName(name);

        if (userOpt.isPresent()) {
            return userMapper.toUserResponse(userOpt.get());
        }
        throw new UserNotFoundException(name);
    }


}
