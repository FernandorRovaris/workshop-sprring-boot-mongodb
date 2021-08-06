package com.spring.spring.services;

import java.util.List;
import java.util.Optional;

import com.spring.spring.domain.Post;
import com.spring.spring.repository.PostRepository;
import com.spring.spring.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(()-> new ObjectNotFoundException("not found"));
    
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContaining(text);
    }

}
