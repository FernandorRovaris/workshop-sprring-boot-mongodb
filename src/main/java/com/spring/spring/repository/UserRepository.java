package com.spring.spring.repository;

import com.spring.spring.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    
}