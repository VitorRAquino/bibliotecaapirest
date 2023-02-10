package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Livro;

import java.time.LocalDateTime;

public class DetalhesDoLivroDto {

    private final String nomeUsuarioAlterou;
    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;

    private String nomeAutor;

    private String nomeCategoria;
    private LocalDateTime dataAlteracao;

    public DetalhesDoLivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.dataCriacao = livro.getDataCriacao();
        this.nomeAutor = livro.getAutor().getNome();
        this.nomeCategoria = livro.getCategoria().getNome();
        this.nomeUsuario = livro.getUsuarioCriou().getNome();
        this.nomeUsuarioAlterou = livro.getUsuarioAlterou().getNome();
    }

    public String getNomeUsuarioAlterou() {
        return nomeUsuarioAlterou;
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

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }
}
