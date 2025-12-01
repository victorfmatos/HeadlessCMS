package com.victorfmatos.cms.project.repository;

import com.victorfmatos.cms.project.domain.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByAuthorId(Long authorId);

  List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String title, String content);
}
