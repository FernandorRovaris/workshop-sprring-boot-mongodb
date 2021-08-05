package com.spring.spring.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.spring.spring.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UserResouce {

    
    @GetMapping
    public ResponseEntity<List<User>> findALL(){
        User user1 = new User(1L,"maria","maria@email.com");
        User user2 = new User(1L,"alex","alex@email.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1,user2));
        return ResponseEntity.ok().body(list);
    }
    
}