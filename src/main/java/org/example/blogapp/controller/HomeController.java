package org.example.blogapp.controller;

import org.example.blogapp.model.Post;
import org.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class HomeController { // Controls Home Screen Functionality

    private final PostService postService; // Dependency on PostService

    @Autowired // Autowires the PostService dependency via constructor injection
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/") // Handles GET requests to the root URL
    public String displayAllPosts(Model model) {

        Collection<Post> posts = this.postService.getAll(); // Retrieves all posts from the PostService
        model.addAttribute("posts", posts); // Adds the posts to the model with the key "posts"

        return "home"; // Returns the name of the view to be rendered (typically "home.html" or similar)
    }

}
