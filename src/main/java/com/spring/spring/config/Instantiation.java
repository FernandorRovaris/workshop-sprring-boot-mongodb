package com.spring.spring.config;

import java.util.Arrays;

import com.spring.spring.domain.User;
import com.spring.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        
        repository.deleteAll();

        User user1 = new User(null, "Maria", "Maria@email.com");
        User user2 = new User(null, "Alex", "Alex@email.com");
        User user3 = new User(null, "Pedro", "Pedro@email.com");
        
        repository.saveAll(Arrays.asList(user1,user2, user3));

    }

    
}
