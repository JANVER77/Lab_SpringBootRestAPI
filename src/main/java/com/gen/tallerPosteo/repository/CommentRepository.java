package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
}
