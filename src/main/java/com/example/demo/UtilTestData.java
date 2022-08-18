package com.example.demo;

import com.example.demo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilTestData {

    @Autowired
    PrimaryKeyGenerator primaryKeyGenerator;

    public List<UserEntity> generateUserMockData(){

        List<UserEntity> users = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            UserEntity user = new UserEntity();

            user.setId(primaryKeyGenerator.getPrimaryKey());
            String name = "User"+i;
            user.setName(name);
            user.setEmail(name.toLowerCase()+"@domain.com");
            users.add(user);
        }

        return users;
    }

}
