/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.config;

import com.udemy.workshopmongo.domain.User;
import com.udemy.workshopmongo.repository.UserRepository;
import java.util.List;
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
    private UserRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        
        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");
        
        repository.saveAll(List.of(u1,u2,u3));
    }
}
