/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.service;

import com.udemy.workshopmongo.domain.User;
import com.udemy.workshopmongo.dto.UserDTO;
import com.udemy.workshopmongo.repository.UserRepository;
import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> findAll(){
        return repository.findAll();
    }
    
    public User findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }
    
    public User insert(User user){
        return repository.insert(user);
    }
    
    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
