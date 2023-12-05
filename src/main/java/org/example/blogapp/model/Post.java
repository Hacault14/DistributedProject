package org.example.blogapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "posts")
@SequenceGenerator(name = "post_seq_gen", sequenceName = "post_seq", initialValue = 10, allocationSize = 1)
public class Post { //model class for posts

    public static final int MIN_TITLE_LENGTH = 7; //varible to store min title length, can be changed

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    @Column(name = "id")
    private Long id; //variable for comment ID


    @Column(name = "image_data", columnDefinition = "BLOB")
    private String imageData; //variable for storing images

    @Length(min = MIN_TITLE_LENGTH, message = "Title must be at least " + MIN_TITLE_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the title") //ensuring not empty
    @Column(name = "title", nullable = false)
    private String title; //variable for storing post title

    @NotEmpty(message = "Please write something")
    @Column(name = "body", columnDefinition = "TEXT", nullable = false) //ensuring not empty
    private String body; //variable for storing post content

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false) //ensuring not empty
    private Date creationDate; //variable for creation date

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Collection<Comment> comments; //variable for comments under posts

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private BlogUser user; //variable to store user of post.

    @Override
    public String toString() { //to string method for model class
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", image='" + imageData + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
