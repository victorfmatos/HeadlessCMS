package com.victorfmatos.cms.project.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  public Comment() {
  }

  public Comment(Long id, String content, LocalDateTime createdAt, Post post, Author author) {
    this.id = id;
    this.content = content;
    this.createdAt = createdAt;
    this.post = post;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Post getPost() {
    return post;
  }

  public Author getAuthor() {
    return author;
  }
}
