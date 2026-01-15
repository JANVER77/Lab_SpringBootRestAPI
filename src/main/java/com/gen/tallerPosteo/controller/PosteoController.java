package com.gen.tallerPosteo.controller;

import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.model.Posteo;
import com.gen.tallerPosteo.service.IPosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PosteoController {
    private final IPosteoService posteoService;  // ← Interface, no clase
    @Autowired
    public PosteoController(IPosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listarTodos() {
        return posteoService.obtenerPosteos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posteo> obtenerPorId(@PathVariable Long id) {
        return posteoService.obtenerPosteosPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/crear")
    public ResponseEntity<Posteo> crearPost(@RequestBody Posteo posteo) {
        Posteo guardado = posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Posteo> actualizar(
            @PathVariable Long id,
            @RequestBody Posteo posteoActualizado) {
        Posteo actualizado = posteoService.editarPosteo(id, posteoActualizado);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        posteoService.borrarPosteo(id);
        return ResponseEntity.ok("Post Borrado con exito");
    }

    @PostMapping("/{posteoId}/autores/{autorId}")
    public ResponseEntity<Posteo> asignarAutor(
            @PathVariable Long posteoId,
            @PathVariable Long autorId) {

        Posteo actualizado = posteoService.asignarAutor(posteoId, autorId);
        return ResponseEntity.ok(actualizado);
    }

    @PostMapping("/{posteoId}/comentarios")
    public ResponseEntity<Posteo> agregarComentario(
            @PathVariable Long posteoId,
            @RequestBody Comment comentario) {

        Posteo actualizado = posteoService.agregarComentario(posteoId, comentario);
        return ResponseEntity.ok(actualizado);    }

    @GetMapping("/{posteoId}/comentarios")
    public ResponseEntity<List<Comment>> obtenerComentarios(@PathVariable Long posteoId) {
        List<Comment> comentarios = posteoService.obtenerComentariosPost(posteoId);
        return ResponseEntity.ok(comentarios);
    }
}