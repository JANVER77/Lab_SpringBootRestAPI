package com.gen.tallerPosteo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gen.tallerPosteo.model.Posteo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "autores")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Autor;
    private String nombre;
    private String email;


    @ManyToOne
    @JoinColumn(name = "posteo_id")
    @JsonBackReference
    private Posteo posteo;

    public Author() {
    }

    public Author(Long id_Autor, String nombre, String email) {
        this.id_Autor = id_Autor;
        this.nombre = nombre;
        this.email = email;

    }

    public Long getId_Autor() {
        return id_Autor;
    }

    public void setId_Autor(Long id_Autor) {
        this.id_Autor = id_Autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Posteo getPosteo() {
        return posteo;
    }

    public void setPosteo(Posteo posteo) {
        this.posteo = posteo;
    }
}
