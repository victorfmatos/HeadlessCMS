package com.victorfmatos.cms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorfmatos.cms.project.domain.Comment;
import com.victorfmatos.cms.project.repository.CommentRepository;

@Service
public class CommentService {
  @Autowired
  private final CommentRepository commentRepository;

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public List<Comment> findAll() {
    return commentRepository.findAll();
  }

  public Optional<Comment> findById(Long id) {
    return commentRepository.findById(id);
  }

  public List<Comment> findByAuthorId(Long authorId) {
    return commentRepository.findByAuthorId(authorId);
  }

  public List<Comment> findByPostId(Long postId) {
    return commentRepository.findByPostId(postId);
  }

  public List<Comment> searchByKeyword(String keyword) {
    return commentRepository.findByContentContainingIgnoreCase(keyword);
  }

  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }

  public void deleteById(Long id) {
    commentRepository.deleteById(id);
  }

}
