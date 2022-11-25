/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.dto;

import com.udemy.workshopmongo.domain.User;
import java.io.Serializable;

/**
 *
 * @author Jorge
 */
public class AuthorDTO implements Serializable{

    private String id;
    private String name;

    public AuthorDTO() {
    }
    
    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
