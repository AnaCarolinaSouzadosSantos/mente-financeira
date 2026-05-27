package com.anacarolina.mentefinanceira.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double valor;

    private LocalDate data;

    private String tipo; // Ex: "RECEITA" ou "DESPESA"

    // ==========================================
    // CONFIGURAÇÃO DO RELACIONAMENTO (Muitos para Um)
    // ==========================================
    @ManyToOne // Muitas transações pertencem a uma Categoria
    @JoinColumn(name = "categoria_id") // Cria a coluna de chave estrangeira no banco de dados
    private Categoria categoria;

    // ==========================================
    // CONSTRUTORES
    // ==========================================
    public Transacao() {
    }

    public Transacao(Long id, String descricao, Double valor, LocalDate data, String tipo, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // ==========================================
    // GETTERS E SETTERS
    // ==========================================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
