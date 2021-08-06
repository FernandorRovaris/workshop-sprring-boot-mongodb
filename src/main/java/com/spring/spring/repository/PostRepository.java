package com.spring.spring.repository;

import java.util.List;

import com.spring.spring.domain.Post;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContaining(String text);

}