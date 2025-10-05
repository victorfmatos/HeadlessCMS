package com.victorfmatos.cms.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorfmatos.cms.project.domain.Post;
import com.victorfmatos.cms.project.dto.PostCreateDTO;
import com.victorfmatos.cms.project.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getAllPosts() {
    return postService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable Long id) {
    return postService.findById(id).map(post -> new ResponseEntity<>(post, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/author/{authorId}")
  public List<Post> getPostByAuthorId(@PathVariable Long authorId) {
    return postService.findByAuthorId(authorId);
  }

  @GetMapping("/search")
  public List<Post> getPostByKeyword(@RequestParam String keyword) {
    return postService.searchByKeyword(keyword);
  }

  @PostMapping
  public ResponseEntity<Post> createPost(@RequestBody PostCreateDTO postCreateDTO) {
    Post savedPost = postService.save(postCreateDTO);
    return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Optional<Post>> updatePost(@PathVariable Long id, @RequestBody PostCreateDTO postCreateDTO) {
    Optional<Post> updatedPost = postService.update(id, postCreateDTO);
    return new ResponseEntity<>(updatedPost, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Long id) {
    postService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
