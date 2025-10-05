package com.victorfmatos.cms.project.repository;

import com.victorfmatos.cms.project.domain.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByAuthorId(Long authorId);

  List<Comment> findByPostId(Long postId);

  List<Comment> findByContentContainingIgnoreCase(String content);
}