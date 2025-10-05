package com.victorfmatos.cms.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorfmatos.cms.project.domain.Author;
import com.victorfmatos.cms.project.domain.Post;
import com.victorfmatos.cms.project.dto.PostCreateDTO;
import com.victorfmatos.cms.project.repository.PostRepository;

@Service
public class PostService {
  @Autowired
  private final PostRepository postRepository;

  @Autowired
  private final AuthorService authorService;

  public PostService(PostRepository postRepository, AuthorService authorService) {
    this.postRepository = postRepository;
    this.authorService = authorService;
  }

  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Optional<Post> findById(Long id) {
    return postRepository.findById(id);
  }

  public List<Post> findByAuthorId(Long authorId) {
    return postRepository.findByAuthorId(authorId);
  }

  public List<Post> searchByKeyword(String keyword) {
    return postRepository.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
  }

  public Post save(PostCreateDTO postCreateDTO) {
    Optional<Author> author = authorService.findById(postCreateDTO.getAuthorId());
    Post post = new Post();
    post.setTitle(postCreateDTO.getTitle());
    post.setContent(postCreateDTO.getContent());
    post.setAuthor(author.get());
    post.setCreatedAt(LocalDateTime.now());
    post.setUpdatedAt(LocalDateTime.now());
    return postRepository.save(post);
  }

  public Optional<Post> update(Long id, PostCreateDTO postCreateDTO) {
    Optional<Post> optionalPost = postRepository.findById(id);
    Post existingPost = optionalPost.get();
    existingPost.setUpdatedAt(LocalDateTime.now());
    if (optionalPost.isPresent()) {
      if (postCreateDTO.getContent() != null) {
        existingPost.setContent(postCreateDTO.getContent());
      }
      if (postCreateDTO.getTitle() != null) {
        existingPost.setTitle(postCreateDTO.getTitle());
      }
      return Optional.of(postRepository.save(existingPost));
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    postRepository.deleteById(id);
  }
}
