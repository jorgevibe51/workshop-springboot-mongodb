/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.resources;

import com.udemy.workshopmongo.domain.Post;
import com.udemy.workshopmongo.resources.util.URL;
import com.udemy.workshopmongo.service.PostService;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping(value="/posts")
public class PostResource {
    
    @Autowired
    private PostService service;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok()
                .body(service.findById(id));
    }
    
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
        try {
            text = URL.decodeParam(text);
        } catch (UnsupportedEncodingException ex) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok()
                .body(service.finByTitle(text));
    }
}
