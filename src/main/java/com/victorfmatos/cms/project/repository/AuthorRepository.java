package com.victorfmatos.cms.project.repository;

import com.victorfmatos.cms.project.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

  Author findByEmail(String email);

  Author findByName(String name);
}
