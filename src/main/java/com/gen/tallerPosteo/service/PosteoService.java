package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.model.Posteo;
import com.gen.tallerPosteo.repository.ICommentRepository;
import com.gen.tallerPosteo.repository.IPosteoRepository;
import com.gen.tallerPosteo.repository.IAuthorRepository;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IPosteoService {
    private final IPosteoRepository posteoRepository;
    private final IAuthorRepository autorRepository;
    private final ICommentRepository comentarioRepository;

    @Autowired
    public PosteoService(IPosteoRepository posteoRepository, IAuthorRepository autorRepository, ICommentRepository comentarioRepository) {
        this.posteoRepository = posteoRepository;
        this.autorRepository = autorRepository;
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<Posteo> obtenerPosteos() {
        return posteoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> obtenerComentariosPost(Long id) {
        return comentarioRepository.findByPosteo_IdPosteo(id);
/*        Posteo post = posteoRepository.findById(id).orElseThrow(() -> new RuntimeException("Post no encontrado"));
        post.getComentarios().size();
        return post.getComentarios();*/
    }

    @Override
    public Optional<Posteo> obtenerPosteosPorId(Long id) {
        return posteoRepository.findById(id);
    }


    @Override
    public Posteo guardarPosteo(Posteo posteo) {
        return posteoRepository.save(posteo);
    }

    @Override
    public void borrarPosteo(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public Posteo editarPosteo(Long id, Posteo posteoActualizado) {

        Posteo posteoExistente = posteoRepository.findById(id).orElse(null);

        if (posteoExistente != null) {
            posteoExistente.setTitulo(posteoActualizado.getTitulo());
            posteoExistente.setAutor(posteoActualizado.getAutor());

            posteoRepository.save(posteoExistente);
        } else {
            throw new RuntimeException("Persona no encontrada con el id: " + id);
        }
        return posteoExistente;
    }

    @Override
    @Transactional
    public Posteo asignarAutor(Long idPosteo, Long idAutor) {
        Posteo posteo = posteoRepository.findById(idPosteo).orElseThrow(() -> new RuntimeException("Post no encontrado"));

        Author autor = autorRepository.findById(idAutor).orElseThrow(()-> new RuntimeException("Autor no encontrado"));

        posteo.setAutor(autor);
        return posteoRepository.save(posteo);
    }

    @Override
    @Transactional
    public Posteo agregarComentario(Long idPosteo, Comment comentario) {
        Posteo posteo = posteoRepository.findById(idPosteo).orElseThrow(() -> new RuntimeException("Post no encontrado"));

        comentario.setPosteo(posteo);
        posteo.getComentarios().add(comentario);

        comentarioRepository.save(comentario);

        return posteo;
    }


}
