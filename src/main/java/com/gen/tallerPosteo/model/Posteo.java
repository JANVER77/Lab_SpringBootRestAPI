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
    private Long id_Posteo;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", foreignKey = @ForeignKey(name = "FK_POSTEO_AUTOR"))
    //@JsonBackReference
    private Author autor;

    @OneToMany(mappedBy = "posteo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comentarios;

    public Posteo() {
    }

    public Posteo(Long id_Posteo, String titulo) {
        this.id_Posteo = id_Posteo;
        this.titulo = titulo;
    }

    public Long getIdPosteo() {
        return id_Posteo = id_Posteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public List<Comment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comment> comentarios) {
        this.comentarios = comentarios;
    }
}
