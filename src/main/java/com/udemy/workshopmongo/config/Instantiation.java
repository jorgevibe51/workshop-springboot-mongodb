/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.config;

import com.udemy.workshopmongo.domain.Post;
import com.udemy.workshopmongo.domain.User;
import com.udemy.workshopmongo.dto.AuthorDTO;
import com.udemy.workshopmongo.dto.CommentDTO;
import com.udemy.workshopmongo.repository.PostRepository;
import com.udemy.workshopmongo.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Jorge
 */
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
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(u1,u2,u3));
        
        Post p1 = new Post(null, Instant.now(), "Partiu viagem", "Vou para São Paulo. Abraços!!",new AuthorDTO(u1));
        Post p2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!!",new AuthorDTO(u1));
        
        CommentDTO c1 = new CommentDTO("Boa viagem mano!", Instant.now(), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Aproveite!", Instant.now(), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.now(), new AuthorDTO(u2));
        
        p1.getComments().addAll(List.of(c1,c2));
        p2.getComments().add(c3);
        
        postRepository.saveAll(List.of(p1, p2));
        
        u1.getPosts().addAll(List.of(p1,p2));
        userRepository.save(u1);
    }
}
