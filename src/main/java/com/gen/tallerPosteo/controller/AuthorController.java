package com.gen.tallerPosteo.controller;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.service.IAuthorService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> crearAutor(@RequestBody Author autor){
        autorService.guardarAutor(autor);
        return ResponseEntity.ok("Autor guardado exitosamente");
    }

    @GetMapping("/{id}")
    public Author obtenerAutor(@PathVariable Long id){
        return null;
    }

}
