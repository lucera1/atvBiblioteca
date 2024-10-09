package com.curso.domains.dtos;


import com.curso.domains.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


public class LivroDTO {


    private long id;

    @NotNull(message = "O campo titulo não pode ser nulo")
    @NotBlank(message = "O campo titulo não pode estar em branco")
    private String titulo;

    @NotNull(message = "O campo isbn não pode ser nulo")
    @NotBlank(message = "O campo isbn não pode estar em branco")
    private String isbn;

    @NotNull(message = "O campo numeroPaginas não pode ser nulo")
    private int numeroPaginas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra = LocalDate.now();

    @NotNull(message = "O campo valorCompra não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorCompra;

    @NotNull(message = "O campo autor não pode ser nulo")
    private int autor;
    private String nomeAutor;

    @NotNull(message = "O campo editora não pode ser nulo")
    private int editora;
    private String razaoSocial;


    private int status;

    private int conservacao;

    public LivroDTO() {

    }

    public LivroDTO(Livro livro) {
        this.id = livro.getIdLivro();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.dataCompra = livro.getDataCompra();
        this.valorCompra = livro.getValorCompra();
        this.autor = livro.getAutor().getId();
        this.nomeAutor = livro.getAutor().getNome();
        this.editora = livro.getEditora().getId();
        this.razaoSocial = livro.getEditora().getRazaoSocial();
        this.status = livro.getStatus().getId();
        this.conservacao = livro.getConservacao().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo titulo não pode ser nulo") @NotBlank(message = "O campo titulo não pode estar em branco") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull(message = "O campo titulo não pode ser nulo") @NotBlank(message = "O campo titulo não pode estar em branco") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull(message = "O campo isbn não pode ser nulo") @NotBlank(message = "O campo isbn não pode estar em branco") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull(message = "O campo isbn não pode ser nulo") @NotBlank(message = "O campo isbn não pode estar em branco") String isbn) {
        this.isbn = isbn;
    }

    @NotNull(message = "O campo numeroPaginas não pode ser nulo")
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(@NotNull(message = "O campo numeroPaginas não pode ser nulo") int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public @NotNull(message = "O campo valorCompra não pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(@NotNull(message = "O campo valorCompra não pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    @NotNull(message = "O campo autor não pode ser nulo")
    public int getAutor() {
        return autor;
    }

    public void setAutor(@NotNull(message = "O campo autor não pode ser nulo") int autor) {
        this.autor = autor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    @NotNull(message = "O campo editora não pode ser nulo")
    public int getEditora() {
        return editora;
    }

    public void setEditora(@NotNull(message = "O campo editora não pode ser nulo") int editora) {
        this.editora = editora;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getConservacao() {
        return conservacao;
    }

    public void setConservacao(int conservacao) {
        this.conservacao = conservacao;
    }
}
