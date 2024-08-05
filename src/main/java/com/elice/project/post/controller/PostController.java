package com.elice.project.post.controller;

import com.elice.project.post.domain.Post;
import com.elice.project.post.dto.PostDTO;
import com.elice.project.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping(value = "/posts")
  public List<Post> getPost() {
    return postService.getAllPosts();
  }

  @PostMapping("/posts")
  public Post createPost(@RequestBody PostDTO post) {
    return postService.addPost(post);
  }

  @PutMapping("/posts/{id}")
  public Post updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Long id) {
    return postService.updatePost(id, postDTO);
  }

  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable("id") Long id) {
    postService.removePost(id);
    Integer a = 1;


  }
  // TODO asdf
}
