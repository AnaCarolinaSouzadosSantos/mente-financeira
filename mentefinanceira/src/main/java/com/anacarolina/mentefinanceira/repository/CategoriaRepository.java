package com.anacarolina.mentefinanceira.repository;

import com.anacarolina.mentefinanceira.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Diz ao Spring que esta interface gerencia o acesso ao banco de dados
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Prontinho! O JpaRepository já traz todos os métodos do CRUD (save, findAll, deleteById...)
}
