package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Comment;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    List<Comment> obtenerTodos();
    List<Comment> findByPosteo_idPosteo(Long id);
    Optional<Comment> obtenerPorId(Long id);
    Comment guardarComentario(Comment comentario);
    Comment eliminarComentario(Long id);

}
