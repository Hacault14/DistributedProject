package org.example.blogapp.service;

import org.example.blogapp.model.Authority;
import org.example.blogapp.model.BlogUser;
import org.example.blogapp.repository.AuthorityRepository;
import org.example.blogapp.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER"; //variable to store the default role, To add an admin you must manually do it for security.
    private final BCryptPasswordEncoder bcryptEncoder; //encoder used for encoding password into DB
    private final BlogUserRepository blogUserRepository; //JPA Repository to store User Models
    private final AuthorityRepository authorityRepository; //JPA Repository to store role Models

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bcryptEncoder, BlogUserRepository blogUserRepository, AuthorityRepository authorityRepository) {
        this.bcryptEncoder = bcryptEncoder;
        this.blogUserRepository = blogUserRepository; //constructor from implementation
        this.authorityRepository = authorityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //function to get a username from the Repository
        Optional<BlogUser> blogUser = blogUserRepository.findByUsername(username);
        if (blogUser.isPresent()) {
            return blogUser.get();
        } else {
            throw new UsernameNotFoundException("No user found with username " + username);
        }
    }

    @Override
    public Optional<BlogUser> findByUsername(String username) { //function to find a username from the Repository
        return blogUserRepository.findByUsername(username);
    }

    @Override
    public BlogUser saveNewUser(BlogUser blogUser) throws RoleNotFoundException {
        System.err.println("saveNewBlogUser: " + blogUser);
        blogUser.setPassword(this.bcryptEncoder.encode(blogUser.getPassword()));

        blogUser.setEnabled(true); // setting attributes in the user model


        Optional<Authority> addAuthority = this.authorityRepository.findByAuthority(DEFAULT_ROLE);
        if (addAuthority.isPresent()) { //add role to user
            Authority authority = addAuthority.get();
            Collection<Authority> authorities = Collections.singletonList(authority);
            blogUser.setAuthorities(authorities);
            return this.blogUserRepository.saveAndFlush(blogUser); //saving user
        } else { //else for if role is not found
            throw new RoleNotFoundException("Default role not found for blog user with username " + blogUser.getUsername());
        }
    }
}
