package com.spring.webserviceblog.controller;

import com.spring.webserviceblog.model.PostModel;
import com.spring.webserviceblog.model.PostUpdateDTO;
import com.spring.webserviceblog.service.BlogSpringService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogSpringController {
    @Autowired
    BlogSpringService blogSpringService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<PostModel>> getPosts() {
        List<PostModel> posts = blogSpringService.findAll();
        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(posts);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostModel> getPostDetails(@PathVariable("id") long id) {
        PostModel post = blogSpringService.findById(id);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(post);
    }

    @PatchMapping("/post/{id}")
    public ResponseEntity<PostModel> updatePost(@PathVariable("id") long id, @Valid @RequestBody PostUpdateDTO update) {
        PostModel postToEdit = blogSpringService.findById(id);
        if (postToEdit == null) {
            return ResponseEntity.notFound().build();
        }
        postToEdit.partialUpdate(update);
        blogSpringService.save(postToEdit);
        return ResponseEntity.ok(postToEdit);
    }

    @RequestMapping(value = "newpost", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostModel> savePost(@Valid @RequestBody PostModel post) {
        post.setData(LocalDate.now());
        PostModel newPost = blogSpringService.save(post);
        return ResponseEntity.ok(newPost);
    }

}
