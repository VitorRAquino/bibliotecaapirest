package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Categoria;

import java.time.LocalDateTime;

public class DetalhesDoCategoriaDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;

    private String nomeAutor;

    private String nomeCategoria;

    public DetalhesDoCategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.dataCriacao = categoria.getDataCriacao();
        this.nomeUsuario = categoria.getUsuario().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }
}
