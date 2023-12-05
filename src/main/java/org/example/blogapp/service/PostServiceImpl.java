package org.example.blogapp.service;

import org.example.blogapp.model.Post;
import org.example.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    } //constructor

    @Override
    public Optional<Post> getById(Long id) { //function to get post by its ID returns model class
        return postRepository.findById(id);
    }

    @Override
    public Collection<Post> getAll() { //function to get all posts in the repository .
        return postRepository.findAllByOrderByCreationDateDesc();
    }

    @Override
    public Post save(Post post) { //function to save a post into the DB
        return postRepository.saveAndFlush(post);
    }

    @Override
    public void delete(Post post) { //function to delete a post
        postRepository.delete(post);
    }
}
