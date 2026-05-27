package com.anacarolina.mentefinanceira.service;

import com.anacarolina.mentefinanceira.model.Transacao;
import com.anacarolina.mentefinanceira.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository repository;

    
    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Transacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    
    public Transacao salvar(Transacao transacao) {
        return repository.save(transacao);
    }

    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
