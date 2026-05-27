package com.anacarolina.mentefinanceira.repository;

import com.anacarolina.mentefinanceira.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    
}
