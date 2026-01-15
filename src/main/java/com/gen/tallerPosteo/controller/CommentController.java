package com.gen.tallerPosteo.controller;

import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.service.AuthorService;
import com.gen.tallerPosteo.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class CommentController {
    private final CommentService comentarioService;

    public CommentController(CommentService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @GetMapping
    public List<Comment> listarComentarios() {
        return comentarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Comment comentarioPorId(@PathVariable Long id) {
        return comentarioService.obtenerPorId(id).orElseThrow();
    }

    @PostMapping("/comentar")
    public ResponseEntity<String> CrearComentario(@RequestBody Comment comentario){
        comentarioService.guardarComentario(comentario);
        return ResponseEntity.ok("Comentario publicado");
    }


}
