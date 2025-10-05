package com.victorfmatos.cms.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorfmatos.cms.project.domain.Comment;
import com.victorfmatos.cms.project.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping
  public List<Comment> getAllComments() {
    return commentService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
    return commentService.findById(id).map(comment -> new ResponseEntity<>(comment, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/author/{authorId}")
  public List<Comment> getCommentByAuthorId(@PathVariable Long authorId) {
    return commentService.findByAuthorId(authorId);
  }

  @GetMapping("/post/{postId}")
  public List<Comment> getCommentByPostId(@PathVariable Long postId) {
    return commentService.findByPostId(postId);
  }

  @GetMapping("/search")
  public List<Comment> getCommentByKeyword(@RequestBody String keyword) {
    return commentService.searchByKeyword(keyword);
  }

  @PostMapping
  public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
    Comment savedComment = commentService.save(comment);
    return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
    commentService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
