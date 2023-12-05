package org.example.blogapp.service;

import org.example.blogapp.model.Comment;
import org.example.blogapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) { //constructor
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) { //function to save a comment in to the DB
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void delete(Comment comment) { //function to delete a comment
        commentRepository.delete(comment);
    }
}
