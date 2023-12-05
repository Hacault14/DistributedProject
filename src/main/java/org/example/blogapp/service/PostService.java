package org.example.blogapp.service;

import org.example.blogapp.model.Post;

import java.util.Collection;
import java.util.Optional;

public interface PostService {

    Optional<Post> getById(Long id); //function to get post by its ID returns model class

    Collection<Post> getAll(); //function to get all posts in the repository .

    Post save(Post post); //function to save a post into the DB

    void delete(Post post); //function to delete a post
}

