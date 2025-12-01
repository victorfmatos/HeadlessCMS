package com.victorfmatos.cms.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.victorfmatos.cms.project.domain.Author;
import com.victorfmatos.cms.project.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public List<Author> getAllAuthors() {
    return authorService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
    return authorService.findById(id).map(author -> new ResponseEntity<>(author, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/search")
  public Author getAuthorByNameOrEmail(@RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "email", required = false) String email) {
    if (email != null && name != null) {
      Author authorEmailService = authorService.findByEmail(email);
      Author authorNameService = authorService.findByName(name);
      if (authorNameService == authorEmailService) {
        return authorNameService;
      } else {
        return null;
      }
    } else if (email != null)
      return authorService.findByEmail(email);
    else if (name != null)
      return authorService.findByName(name);
    return null;
  }

  @PostMapping
  public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
    Author savedAuthor = authorService.save(author);
    return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Optional<Author>> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
    Optional<Author> updatedAuthor = authorService.update(id, author);
    return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    authorService.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
