package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.dtos.AutorDTO;
import com.curso.repositories.AutorRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepo;

    public List<AutorDTO> findAll(){
        return autorRepo.findAll().stream().map
                (obj -> new AutorDTO(obj)).collect(Collectors.toList());
    }

    public Autor findbyId(int id){
        Optional<Autor> obj = autorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado! Id: "+id));
    }
}
