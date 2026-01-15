package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.model.Posteo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPosteoService {
    List<Posteo> obtenerPosteos();
    List<Comment> obtenerComentariosPost(Long idPost);
    Optional<Posteo> obtenerPosteosPorId(Long id);
    Posteo guardarPosteo(Posteo posteo);
    void borrarPosteo(Long id);
    Posteo editarPosteo(Long id, Posteo posteoActualizado);
    Posteo asignarAutor(Long idPosteo, Long idAutor);
    Posteo agregarComentario(Long idAutor, Comment comentario);


}
