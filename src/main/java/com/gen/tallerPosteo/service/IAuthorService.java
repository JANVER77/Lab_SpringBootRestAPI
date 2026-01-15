package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    List<Author> obtenerTodos();
    Optional <Author> obtenerPorId(Long id);
    Author guardarAutor(Author autor);
    Author eliminarAutor(Long id);
}
