package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.repository.ICommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService{
    private final ICommentRepository comentarioRepository;

    public CommentService(ICommentRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Comment> obtenerTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comment> findByPosteo_idPosteo(Long id) {
        return List.of();
    }


    @Override
    public Optional<Comment> obtenerPorId(Long id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public Comment guardarComentario(Comment comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comment eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
        return null;
    }
}
