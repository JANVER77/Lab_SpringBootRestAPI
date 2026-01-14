package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPosteoRepository extends JpaRepository<Posteo, Long> {
}
