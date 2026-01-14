package com.gen.tallerPosteo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Posteo")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosteo;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Comment comentariosPosteos;

    @OneToMany(mappedBy = "posteoAutor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Author> autores;

    public Posteo() {
    }

    public Posteo(Long idPosteo, String titulo) {
        this.idPosteo = idPosteo;
        this.titulo = titulo;
    }

    public Long getIdPosteo() {
        return idPosteo;
    }

    public void setIdPosteo(Long idPosteo) {
        this.idPosteo = idPosteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Comment getComentariosPosteos() {
        return comentariosPosteos;
    }

    public void setComentariosPosteos(Comment comentariosPosteos) {
        this.comentariosPosteos = comentariosPosteos;
    }

    public List<Author> getAutores() {
        return autores;
    }

    public void setAutores(List<Author> autores) {
        this.autores = autores;
    }
}
