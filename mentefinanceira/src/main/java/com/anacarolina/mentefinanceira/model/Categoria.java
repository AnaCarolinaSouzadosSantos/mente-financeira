package com.anacarolina.mentefinanceira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Diz ao Spring que isso é uma tabela do banco de dados
@Table(name = "tb_categoria") // Define o nome da tabela no banco
public class Categoria {

    @Id // Define como Chave Primária (ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento (1, 2, 3...)
    private Long id;

    private String nome;

    private String descricao;

    // ==========================================
    // CONSTRUTORES (Padrão e Com Argumentos)
    // ==========================================
    public Categoria() {
    }

    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    // ==========================================
    // GETTERS E SETTERS (O seu "copia e cola" precisa disso)
    // ==========================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}