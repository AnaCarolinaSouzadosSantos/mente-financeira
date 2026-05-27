package com.anacarolina.mentefinanceira.controller;

import com.anacarolina.mentefinanceira.model.Transacao;
import com.anacarolina.mentefinanceira.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes") 
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    
    @GetMapping
    public List<Transacao> listarTodos() {
        return service.listarTodas();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(transacao -> ResponseEntity.ok(transacao))
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Transacao> criar(@RequestBody Transacao transacao) {
        Transacao novaTransacao = service.salvar(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Transacao> atualizar(@PathVariable Long id, @RequestBody Transacao transacao) {
        return service.buscarPorId(id).map(existente -> {
            transacao.setId(id);
            Transacao atualizada = service.salvar(transacao);
            return ResponseEntity.ok(atualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}