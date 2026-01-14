package com.gen.tallerPosteo.controller;

import com.gen.tallerPosteo.model.Posteo;
import com.gen.tallerPosteo.service.PosteoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Publicaciones")
public class PosteoController {
    private final PosteoService posteoService;

    @Autowired
    public PosteoController(PosteoService posteoService) {
        this.posteoService = posteoService;
    }

    @GetMapping("/todas")
    public List<Posteo> listaPublicaciones(){
        return posteoService.obtenerPosteos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPosteoPorId(@PathVariable Long id){
        return posteoService.obtenerPosteosPorId(id);
    }

    @PostMapping("/postear")
    public ResponseEntity<String> crearPublicacion(@RequestBody Posteo publicacion){
        posteoService.guardarPublicacion(publicacion);
        return ResponseEntity.ok("Publicacion exitosa!!!");
    }

    @DeleteMapping ("/borrar/{id}")

    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        posteoService.deletPosteo(id);
        return ResponseEntity.ok("Publicacion eliminada con éxito");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarPublicacion(@PathVariable Long id, @RequestBody Posteo publicacionActualizada){
        posteoService.editarPosteo(id, publicacionActualizada);
        return ResponseEntity.ok("Publicacion actualizada exitosamente!!!");
    }




}
