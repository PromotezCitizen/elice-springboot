package com.elice.project.post.service;

import com.elice.project.post.domain.Post;
import com.elice.project.post.dto.PostDTO;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
  List<Post> posts = new ArrayList<>();

  private long generateId() {
    if (posts.isEmpty()) return 1L;
    return posts.getLast().getId() + 1;
  }

  public List<Post> getAllPosts() { return posts; }

  public Post addPost(PostDTO postDto) {
    Post newPost = new Post(
      postDto.getTitle(),
      postDto.getContent()
    );
    newPost.setId(generateId());
    posts.add(newPost);
    return newPost;
  }

  public Post updatePost(Long id, PostDTO postDTO) {
    return  posts.stream()
      .filter(
        post -> post.getId() == id
      )
      .findFirst()
      .map(post -> {
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        return post;
      })
      .orElse(null);
  }

  public void removePost(Long id) {
    posts.stream()
      .filter(post -> post.getId() == id)
      .findFirst()
      .ifPresent(
        post -> posts.remove(post)
      );
  }
}
