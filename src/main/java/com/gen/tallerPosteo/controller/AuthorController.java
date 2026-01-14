package com.gen.tallerPosteo.controller;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.service.IAuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AuthorController {
    private final IAuthorService autorService;

    public AuthorController(IAuthorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Author> obtenerAutores() {
        return autorService.obtenerTodos();
    }

    @PostMapping("/crear")
    public Author crearAutor(@RequestBody Author autor){
        return autorService.guardarAutor(autor);
    }

    @GetMapping("/{id}")
    public Author obtenerAutor(@PathVariable Long id){
        return autorService.
    }
}
