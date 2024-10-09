package com.curso.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_autor")
    private int id;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String documentoPessoal;

    @JsonIgnore
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor() {

    }

    public Autor(int id, String nome, String documentoPessoal) {
        this.id = id;
        this.nome = nome;
        this.documentoPessoal = documentoPessoal;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(@NotNull @NotBlank String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
