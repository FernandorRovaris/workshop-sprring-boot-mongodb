package com.spring.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.spring.domain.User;
import com.spring.spring.repository.UserRepository;
import com.spring.spring.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}