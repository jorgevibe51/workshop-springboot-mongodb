/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.resources;

import com.udemy.workshopmongo.domain.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(value="/users")
public class UserResouce {
    
    @RequestMapping(method = RequestMethod.GET) //out @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("1", "Alex Green", "alex@gmail.com");
        List<User> list = Arrays.asList(maria, alex);
        return ResponseEntity.ok().body(list);
    }
}
