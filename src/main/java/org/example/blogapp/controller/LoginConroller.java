package org.example.blogapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginConroller { // Controls Login Functionality

    @GetMapping("/login") // Handles GET requests to "/login"
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:/"; // Redirects to the root context if the user is already logged in
        } else {
            return "login"; // Renders the login view if the user is not logged in
        }
    }
}
