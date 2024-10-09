package com.curso.domains;


import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
public class Livro{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
    private long idLivro;

    @NotNull @NotBlank
    private String titulo;

    @NotNull @NotBlank
    private String isbn;

    @NotNull
    private int numeroPaginas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra = LocalDate.now();

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorCompra;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "conservacao")
    private Conservacao conservacao;

    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "ideditora")
    private Editora editora;

    public Livro() {

    }

    public Livro(long idLivro, String titulo, String isbn, int numeroPaginas,
                 LocalDate dataCompra, BigDecimal valorCompra,
                 Status status, Conservacao conservacao, Autor autor,
                 Editora editora) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
        this.status = status;
        this.conservacao = conservacao;
        this.autor = autor;
        this.editora = editora;
    }


    public long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(long idLivro) {
        this.idLivro = idLivro;
    }

    public @NotNull @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull @NotBlank String titulo) {
        this.titulo = titulo;
    }

    public @NotNull @NotBlank String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull @NotBlank String isbn) {
        this.isbn = isbn;
    }

    @NotNull
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(@NotNull int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(@NotNull @Digits(integer = 15, fraction = 3) BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Conservacao getConservacao() {
        return conservacao;
    }

    public void setConservacao(Conservacao conservacao) {
        this.conservacao = conservacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
}
