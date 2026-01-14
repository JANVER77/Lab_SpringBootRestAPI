package com.gen.tallerPosteo.service;

import com.gen.tallerPosteo.model.Author;
import com.gen.tallerPosteo.model.Comment;
import com.gen.tallerPosteo.model.Posteo;
import com.gen.tallerPosteo.repository.IPosteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PosteoService implements IPosteoService{
    private final IPosteoRepository posteoRepository;

    @Autowired
    public PosteoService(IPosteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerPosteos() {
        return posteoRepository.findAll();
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

        if (posteoExistente != null){
            posteoExistente.setTitulo(posteoActualizado.getTitulo());
            posteoExistente.setAutores(posteoActualizado.getAutores());

            posteoRepository.save(posteoExistente);
        } else {
            throw new RuntimeException("Persona no encontrada con el id: " + id);
        }
}
