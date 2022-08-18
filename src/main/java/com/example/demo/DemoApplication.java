package com.example.demo;

import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@Autowired
	PrimaryKeyGenerator primaryKeyGenerator;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name->{

				UserEntity userEntity = new UserEntity();
				userEntity.setId(primaryKeyGenerator.getPrimaryKey());
				userEntity.setName(name);
				userEntity.setEmail(name.toLowerCase()+"@domain.com");
				userRepository.save(userEntity);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
