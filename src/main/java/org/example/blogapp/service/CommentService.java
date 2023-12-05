package org.example.blogapp.service;

import org.example.blogapp.model.Comment;

public interface CommentService {

    Comment save(Comment comment); //function to save a comment in to the DB

    void delete(Comment comment); //function to delete a comment

}
