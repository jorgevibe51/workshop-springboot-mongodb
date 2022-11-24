/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udemy.workshopmongo.resources.exception;

import com.udemy.workshopmongo.service.exception.ObjectNotFoundException;
import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Jorge
 */
@ControllerAdvice
public class ResouceExceptionHandler {
    
    @ExceptionHandler
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError err = new StandardError(Instant.now(),
                HttpStatus.NOT_FOUND.value(), 
                "Não encontrado", 
                e.getMessage(), 
                request.getRequestURI());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
