package com.anacarolina.mentefinanceira.controller;

import com.anacarolina.mentefinanceira.model.Categoria;
import com.anacarolina.mentefinanceira.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api/categorias") 
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    
    @GetMapping
    public List<Categoria> listarTodos() {
        return service.listarTodas();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(categoria -> ResponseEntity.ok(categoria)) 
                .orElse(ResponseEntity.notFound().build());    
    }

    
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = service.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria); // Retorna 201 Created
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.buscarPorId(id).map(existente -> {
            categoria.setId(id); // Garante que vai atualizar o ID correto
            Categoria atualizada = service.salvar(categoria);
            return ResponseEntity.ok(atualizada); // Retorna 200 OK
        }).orElse(ResponseEntity.notFound().build()); // Retorna 404
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content (Deletado com sucesso)
        }
        return ResponseEntity.notFound().build(); // Retorna 404
    }
}
