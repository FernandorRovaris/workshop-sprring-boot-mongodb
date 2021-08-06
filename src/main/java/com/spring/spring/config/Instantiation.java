package com.spring.spring.config;

import java.time.Instant;
import java.util.Arrays;

import com.spring.spring.domain.Post;
import com.spring.spring.domain.User;
import com.spring.spring.dto.AuthorDTO;
import com.spring.spring.dto.CommentDTO;
import com.spring.spring.repository.PostRepository;
import com.spring.spring.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "Maria", "Maria@email.com");
        User user2 = new User(null, "Alex", "Alex@email.com");
        User user3 = new User(null, "Pedro", "Pedro@email.com");
        
        userRepository.saveAll(Arrays.asList(user1,user2, user3));

        Post post1 = new Post(null, Instant.now(), "Partiu viagem","Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
        Post post2 = new Post(null, Instant.now(), "Bom dia","Acordei feliz hoje!", new AuthorDTO(user1));

        CommentDTO comment1 = new CommentDTO("Boa viagem mano!", Instant.now(), new AuthorDTO(user2));
        CommentDTO comment2 = new CommentDTO("Aproveite!", Instant.now(), new AuthorDTO(user3));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", Instant.now(), new AuthorDTO(user2));

        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1,post2));

        user1.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(user1);

    }

    
}
