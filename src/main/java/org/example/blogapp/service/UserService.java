package org.example.blogapp.service;

import org.example.blogapp.model.BlogUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.management.relation.RoleNotFoundException;
import java.util.Optional;

public interface UserService extends UserDetailsService { //implementation for User service

    Optional<BlogUser> findByUsername(String username); //function to find a username

    BlogUser saveNewUser(BlogUser blogUser) throws RoleNotFoundException; //function to save a user into the DB.

}
