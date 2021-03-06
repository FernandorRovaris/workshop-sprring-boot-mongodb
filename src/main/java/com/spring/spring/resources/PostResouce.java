package com.spring.spring.resources;

import com.spring.spring.domain.Post;
import com.spring.spring.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "posts")
public class PostResouce {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public Post findById(@PathVariable String id) {
        Post post = service.findById(id);
        return post;
    }

}
