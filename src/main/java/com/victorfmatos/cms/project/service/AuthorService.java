package com.victorfmatos.cms.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorfmatos.cms.project.domain.Author;
import com.victorfmatos.cms.project.repository.AuthorRepository;

@Service
public class AuthorService {
  @Autowired
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  public Optional<Author> findById(Long id) {
    return authorRepository.findById(id);
  }

  public Author findByEmail(String email) {
    return authorRepository.findByEmail(email);
  }

  public Author findByName(String name) {
    return authorRepository.findByName(name);
  }

  public Author save(Author author) {
    // Produzir validação de email
    return authorRepository.save(author);
  }

  public Optional<Author> update(Long id, Author author) {
    // Produzir validação de email
    Optional<Author> existingAuthorOptional = authorRepository.findById(id);
    if (existingAuthorOptional.isPresent()) {
      Author existingAuthor = existingAuthorOptional.get();
      if (author.getName() != null) {
        existingAuthor.setName(author.getName());
      }
      if (author.getEmail() != null) {
        existingAuthor.setEmail(author.getEmail());
      }
      if (author.getPassword() != null) {
        existingAuthor.setPassword(author.getPassword());
      }
      if (author.getRole() != null) {
        existingAuthor.setRole(author.getRole());
      }
      return Optional.of(authorRepository.save(existingAuthor));
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    authorRepository.deleteById(id);
  }

}
