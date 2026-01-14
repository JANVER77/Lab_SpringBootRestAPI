package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository <Author, Long> {
}
