package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findByPosteo_IdPosteo(Long id);
}
