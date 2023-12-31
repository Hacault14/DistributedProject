package org.example.blogapp.repository;

import org.example.blogapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> { // JPA repo to store posts

    Collection<Post> findAllByOrderByCreationDateDesc(); //function to find all posts

    Optional<Post> findById(Long id); //function to find a post by ID
}
