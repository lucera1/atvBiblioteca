package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.Livro;
import com.curso.domains.dtos.LivroDTO;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.EditoraRepository;
import com.curso.repositories.LivroRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepo;
    @Autowired
    private AutorRepository autorRepo;
    @Autowired
    private EditoraRepository editoraRepo;

    public List<LivroDTO> findAll(){
        return livroRepo.findAll().stream().map
                (obj -> new LivroDTO(obj)).collect(Collectors.toList());
    }

    public Livro findbyId(Long id){
        Optional<Livro> obj = livroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Id: "+id));
    }



    public Livro findbyIsbn(String isbn){
        Optional<Livro> obj = livroRepo.findByIsbn(isbn);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! Isbn: "+isbn));
    }

    public Livro create(LivroDTO dto){
        dto.setId(null);
        validaIsbn(dto);
        Livro obj = new Livro(dto);
        return livroRepo.save(obj);
    }

    public void validaIsbn(LivroDTO dto) {
        Optional<Livro> obj = livroRepo.findByIsbn((dto.getIsbn()));
        if (obj.isPresent() && obj.get().getIdLivro() != dto.getId()) {
            throw new DataIntegrityViolationException("Isbn ja cadastrado!");
        }

        Optional<Autor> autor = autorRepo.findById(dto.getAutor());
        if(!autor.isPresent()){
            throw new DataIntegrityViolationException("Autor -"+ dto.getAutor() +" não está cadastrado!");
        }

        Optional<Editora> editora = editoraRepo.findById(dto.getEditora());
        if(!editora.isPresent()){
            throw new DataIntegrityViolationException("Editora -"+ dto.getEditora() +" não está cadastrado!");
        }

    }

    public Livro update(Long id, LivroDTO objDto){
        objDto.setId(id);
        Livro oldObj = findbyId(id);
        oldObj = new Livro(objDto);
        return livroRepo.save(oldObj);
    }

    public void delete(Long id){
        Livro obj = findbyId(id);
        livroRepo.deleteById(id);
    }

}
