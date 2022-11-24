/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.resources;

import com.udemy.workshopmongo.domain.User;
import com.udemy.workshopmongo.dto.UserDTO;
import com.udemy.workshopmongo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(value="/users")
public class UserResouce {
    
    @Autowired
    private UserService service;
    
    @RequestMapping(method = RequestMethod.GET) //out @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        //return ResponseEntity.ok().body(service.findAll());
        return ResponseEntity.ok()
                .body(
                        service.findAll().stream()
                        .map(x -> new UserDTO(x))
                        .collect(Collectors.toList())
                );
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return ResponseEntity.ok()
                .body(
                    new UserDTO(service.findById(id))
                );
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = service.insert(service.fromDTO(userDTO));
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(user.getId())
                .toUri()).build();
    }
}
