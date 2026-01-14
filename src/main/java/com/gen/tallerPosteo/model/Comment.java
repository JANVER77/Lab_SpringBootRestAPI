package com.gen.tallerPosteo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "comentarios")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Comentario;
    private String text;
    private String createdAt;

    @OneToMany(mappedBy = "comentariosPosteos", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Posteo> posteos;


    public Comment() {
    }

    public Comment(Long id_Comentario, String text, String createdAt) {
        this.id_Comentario = id_Comentario;
        this.text = text;
        this.createdAt = createdAt;
    }

    public Long getId_Comentario() {
        return id_Comentario;
    }

    public void setId_Comentario(Long id_Comentario) {
        this.id_Comentario = id_Comentario;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Posteo> getPosteos() {
        return posteos;
    }

    public void setPosteos(List<Posteo> posteos) {
        this.posteos = posteos;
    }
}
