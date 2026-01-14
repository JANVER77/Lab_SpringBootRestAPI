package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.model.Posteo;
import com.gen.tallerPosteo.repository.AuthorRepository;
import com.gen.tallerPosteo.repository.CommentRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class AuthorService implements IAuthorService {
    private final AuthorRepository autorRepository;

    public AuthorService(AuthorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Optional<Author> obtenerPorId(Long id) {
        Author autor = autorRepository.findById(id).orElseThrow();

        return Optional.of();
    }

    @Override
    public Author guardarAutor(Author autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Author agregarPosteo(long autorId, Posteo posteo) {
        return null;
    }

    @Override
    public List<Author> obtenerTodos() {
        return autorRepository.findAll();
    }


}
