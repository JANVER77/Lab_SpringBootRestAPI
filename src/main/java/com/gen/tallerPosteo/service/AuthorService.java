package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.repository.IAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private final IAuthorRepository autorRepository;

    public AuthorService(IAuthorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @Override
    public List<Author> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Author> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public Author guardarAutor(Author autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Author eliminarAutor(Long id) {
        autorRepository.deleteById(id);
        return null;
    }
}
