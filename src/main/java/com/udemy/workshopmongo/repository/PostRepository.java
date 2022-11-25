/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.udemy.workshopmongo.repository;

import com.udemy.workshopmongo.domain.Post;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
    List<Post> findByTitleContainingIgnoreCase(String text);
    
    @Query("{'title':{$regex:?0, $options:'i'}}")
    List<Post> searchByTitle(String text);
    
    @Query("{$and:[{date:{$gte:?1}},{date:{$lte: ?2}},"
            + "{$or:[{'title':{$regex:?0,$options:'i'}},{'body':{$regex:?0,$options:'i'}},{'comments.text':{$regex:?0,$options:'i'}}]}]}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
