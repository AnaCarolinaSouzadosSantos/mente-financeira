package com.anacarolina.mentefinanceira.service;

import com.anacarolina.mentefinanceira.model.Categoria;
import com.anacarolina.mentefinanceira.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class CategoriaService {

    @Autowired 
    private CategoriaRepository repository;

    
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    
    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }

    
    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
