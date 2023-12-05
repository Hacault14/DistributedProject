package org.example.blogapp.controller;

import org.example.blogapp.model.BlogUser;
import org.example.blogapp.model.Comment;
import org.example.blogapp.model.Post;
import org.example.blogapp.service.UserService;
import org.example.blogapp.service.CommentService;
import org.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@SessionAttributes("comment")
public class CommentController { // Controls Comment Functionality

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @Secured("ROLE_USER") // Specifies that only users with the ROLE_USER role can access these methods
    @GetMapping("/comment/{id}")
    public String showComment(@PathVariable Long id, Model model, Principal principal) {

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName(); // Gets the username of the logged-in user
        }

        // Find user by username
        Optional<BlogUser> optionalBlogUser = this.userService.findByUsername(authUsername);
        // Find post by id
        Optional<Post> postOptional = this.postService.getById(id);

        // If both user and post are present, create a new comment object and add it to the model
        if (postOptional.isPresent() && optionalBlogUser.isPresent()) {
            Comment comment = new Comment();
            comment.setPost(postOptional.get());
            comment.setUser(optionalBlogUser.get());
            model.addAttribute("comment", comment); // Add the comment to the model
            System.err.println("GET comment/{id}: " + comment + "/" + id); // Debugging purposes
            return "commentForm"; // Return the view for commentForm
        } else {
            System.err.println("Could not find a post by id: " + id + " or user by logged in username: " + authUsername);
            return "error"; // Return error page
        }
    }

    @Secured("ROLE_USER")
    @PostMapping("/comment")
    public String validateComment(@Valid @ModelAttribute Comment comment, BindingResult bindingResult, SessionStatus sessionStatus) {
        System.err.println("POST comment: " + comment); // Debugging purposes

        // Check for validation errors in the comment
        if (bindingResult.hasErrors()) {
            System.err.println("Comment did not validate");
            return "commentForm"; // Return the comment form to display errors
        } else {
            this.commentService.save(comment); // Save the validated comment using the comment service
            System.err.println("SAVE comment: " + comment); // Debugging purposes
            sessionStatus.setComplete(); // Mark the session complete
            return "redirect:/post/" + comment.getPost().getId(); // Redirect to the post after comment submission
        }
    }
}
