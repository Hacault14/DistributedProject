package org.example.blogapp.controller;

import org.example.blogapp.model.BlogUser;
import org.example.blogapp.model.Post;
import org.example.blogapp.service.UserService;
import org.example.blogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.Optional;

@Controller
@SessionAttributes("post")
public class PostController {

    // Dependency injection for PostService and UserService
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    // Handles GET requests to view a specific post by ID
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal) {

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName(); // Retrieves the logged-in username
        }

        // Find post by ID
        Optional<Post> optionalPost = this.postService.getById(id);
        // If the post exists, add it to the model
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post); // Adds the post to the model

            // Checks if the logged-in user is the owner of the post and informs the view
            if (authUsername.equals(post.getUser().getUsername())) {
                model.addAttribute("isOwner", true); // Indicates that the logged-in user is the owner of the post
            }

            return "post"; // Returns the view to display the post
        } else {
            return "404"; // Returns a 404 error page if the post is not found
        }
    }


    // Handles the creation of a new post view
    @Secured("ROLE_USER")// Ensures that only users with the ROLE_USER role can access this method
    @GetMapping("/createNewPost")
    public String createNewPost(Model model, Principal principal) {

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName(); // Retrieves the logged-in username
        }

        // Find user by username
        Optional<BlogUser> optionalBlogUser = this.userService.findByUsername(authUsername);
        // If the user is found, create a new post and add it to the model
        if (optionalBlogUser.isPresent()) {
            Post post = new Post();
            post.setUser(optionalBlogUser.get()); // Sets the user for the new post
            model.addAttribute("post", post); // Adds the post to the model
            return "postForm"; // Returns the view for creating a new post
        } else {
            return "error"; // Returns an error page if the user is not found
        }
    }

    // Handles the creation of a new post after form submission
    @Secured("ROLE_USER") // Ensures that only users with the ROLE_USER role can access this method
    @PostMapping("/createNewPost")
    public String createNewPost(@Valid @ModelAttribute Post post, BindingResult bindingResult,
                                @RequestParam("imageFile") MultipartFile imageFile, SessionStatus sessionStatus) {
        // Code to create a new post...

        // Checks for validation errors or empty image file
        if (bindingResult.hasErrors() || imageFile.isEmpty()) {
            System.err.println("Post did not validate");
            return "postForm"; // Returns the post form to display errors
        }

        try {
            // Sets the image data from the uploaded file to the Post entity as base64 encoded string
            String base64Image = Base64.getEncoder().encodeToString(imageFile.getBytes());
            post.setImageData(base64Image);
        } catch (IOException e) {
            // Handles exceptions (e.g., logs error, shows error message)
            return "postForm"; // Returns the post form in case of an exception
        }

        // Saves the post if there are no errors
        this.postService.save(post);
        sessionStatus.setComplete(); // Marks the session as complete
        return "redirect:/post/" + post.getId(); // Redirects to view the newly created post
    }

    // Handles editing an existing post
    @Secured("ROLE_USER") // Ensures that only users with the ROLE_USER role can access this method
    @GetMapping("editPost/{id}")
    public String editPost(@PathVariable Long id, Model model, Principal principal) {
        // Code to edit an existing post...

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName(); // Retrieves the logged-in username
        }

        // Finds the post by its ID
        Optional<Post> optionalPost = this.postService.getById(id);
        // Checks if the logged-in user is the owner and has permission to edit the post
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Checks if the logged-in user is the owner of the post
            if (authUsername.equals(post.getUser().getUsername())) {
                model.addAttribute("post", post); // Adds the post to the model for editing
                System.err.println("EDIT post: " + post); // For testing and debugging purposes
                return "postForm"; // Returns the post form for editing
            } else {
                System.err.println("Current User has no permissions to edit anything on post by id: " + id); // For testing and debugging purposes
                return "403"; // Returns a forbidden error page
            }
        } else {
            System.err.println("Could not find a post by id: " + id); // For testing and debugging purposes
            return "error"; // Returns an error page if the post is not found
        }
    }

    // Handles deleting an existing post
    @Secured("ROLE_USER") // Ensures that only users with the ROLE_USER role can access this method
    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id, Principal principal) {
        // Code to delete an existing post...

        String authUsername = "anonymousUser";
        if (principal != null) {
            authUsername = principal.getName(); // Retrieves the logged-in username
        }

        // Finds the post by its ID
        Optional<Post> optionalPost = this.postService.getById(id);
        // Checks if the logged-in user is the owner and has permission to delete the post
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            // Checks if the logged-in user is the owner of the post
            if (authUsername.equals(post.getUser().getUsername())) {
                // Deletes the post from the database
                this.postService.delete(post);
                System.err.println("DELETED post: " + post); // For testing and debugging purposes
                return "redirect:/"; // Redirects to the home page after successful deletion
            } else {
                System.err.println("Current User has no permissions to edit anything on post by id: " + id); // For testing and debugging purposes
                return "403"; // Returns a forbidden error page
            }
        } else {
            System.err.println("Could not find a post by id: " + id); // For testing and debugging purposes
            return "error"; // Returns an error page if the post is not found
        }
    }


}
