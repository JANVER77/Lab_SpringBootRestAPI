package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository <Author, Long> {
}
