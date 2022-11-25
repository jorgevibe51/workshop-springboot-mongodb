/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.service;

import com.udemy.workshopmongo.domain.Post;
import com.udemy.workshopmongo.repository.PostRepository;
import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class PostService {
    
    @Autowired
    private PostRepository repository;
    
    public Post findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }
}
