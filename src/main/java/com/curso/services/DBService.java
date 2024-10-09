package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.Livro;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.EditoraRepository;
import com.curso.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

    @Service
    public class DBService {

        @Autowired
        private AutorRepository autorRepo;

        @Autowired
        private EditoraRepository editoraRepo;

        @Autowired
        private LivroRepository livroRepo;

        public void initDB(){

            Autor autor01 = new Autor(0,"Ziraldo","111.111.111-11");
            Autor autor02 = new Autor(0,"Machado de Assis","222.222.222-22");
            Autor autor03 = new Autor (0, "Mario de Andrade", "333.333.333-33");

            Editora editora01 = new Editora(0,"11.111.111.0001-11","Editora Moderna");
            Editora editora02 = new Editora(0,"22.222.222.0001-22","Editora Saraiva");
            Editora editora03 = new Editora(0,"33.333.333.0001-33","Editora Galera");



            Livro livro01 = new Livro(0,"Menino Maluquinho","1111",50,LocalDate.now(), new BigDecimal("30.0"),Status.NAOLIDO,Conservacao.BOM, autor01, editora01);

            Livro livro02 = new Livro(0,"Macunaíma","2222",200,LocalDate.now(), new BigDecimal("45.0"),
                    Status.LIDO, Conservacao.EXCELENTE, autor03, editora03);

            Livro livro03 = new Livro(0,"Dom Casmurro","3333",250,LocalDate.now(), new BigDecimal("55.0"),
                    Status.LENDO, Conservacao.GASTO, autor02, editora02);

            Livro livro04 = new Livro(0,"O Menino Marrom","4444",30,LocalDate.now(), new BigDecimal("15.5"),
                    Status.LIDO, Conservacao.EXCELENTE, autor01, editora01);

            Livro livro05 = new Livro(0,"Paulicéia Desvairada","5555",300,LocalDate.now(), new BigDecimal("60"),
                    Status.LENDO, Conservacao.GASTO, autor03, editora03);

            Livro livro06 = new Livro(0,"A Cartomante","6666",185,LocalDate.now(), new BigDecimal("58.5"),
                    Status.NAOLIDO, Conservacao.MARCASDEUSO, autor02, editora02);

            autorRepo.save(autor01);
            autorRepo.save(autor02);
            autorRepo.save(autor03);

            editoraRepo.save(editora01);
            editoraRepo.save(editora02);
            editoraRepo.save(editora03);

            livroRepo.save(livro01);
            livroRepo.save(livro02);
            livroRepo.save(livro03);
            livroRepo.save(livro04);
            livroRepo.save(livro05);
            livroRepo.save(livro06);
        }
    }

