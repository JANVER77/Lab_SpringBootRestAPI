/*
package com.gen.tallerPosteo.repository;

import com.gen.tallerPosteo.model.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PosteoRepository implements IposteoRepository{
    private final List<Posteo> posteo = new ArrayList<>();

    public PosteoRepository() {
        posteo.add(new Posteo(1L, "Leer mas rapido", "Juan Pineda"));
        posteo.add(new Posteo(2L, "Comer saludable", "Maria Castañeda"));
        posteo.add(new Posteo(3L, "Cambiar de habitos", "Victor Palacios"));
        posteo.add(new Posteo(4L, "Rutina de ejercicio", "Rafael Uribe"));
        posteo.add(new Posteo(5L, "Formatear un computador", "Angel Fernandez"));
        posteo.add(new Posteo(6L, "Aprender JS", "Miguel Davinchi"));
        posteo.add(new Posteo(7L, "Tecnicas de aprendizaje", "Margot Buenaventura"));
        posteo.add(new Posteo(8L, "Dormir bien", "Juanes"));
    }

    @Override
    public List<Posteo> findAll() {
        return posteo;
    }

    @Override
    public Posteo findById(Long id) {
        for(Posteo posteo: posteo){
           if(posteo.getIdPosteo().equals(id)){
               return posteo;
           }
        }
        return null;
    }

    @Override
    public void save(Posteo posteo) {
        this.posteo.add(posteo);
    }
}
*/
