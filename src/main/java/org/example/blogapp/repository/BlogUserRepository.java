package org.example.blogapp.repository;

import org.example.blogapp.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogUserRepository extends JpaRepository<BlogUser, Long> { // JPA repo to store users

    Optional<BlogUser> findByUsername(String username); //function to find a username returns model class

}
