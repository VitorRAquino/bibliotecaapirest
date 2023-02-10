package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Categoria;

import java.time.LocalDateTime;

public class DetalhesDoCategoriaDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;

    private LocalDateTime dataAlteracao;

    public DetalhesDoCategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.dataCriacao = categoria.getDataCriacao();
        this.nomeUsuario = categoria.getUsuarioCriou().getNome();
        this.nomeUsuarioAlterou = categoria.getUsuarioAlterou().getNome();
        this.dataAlteracao = categoria.getDataAlteracao();
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

    public String getNomeUsuarioAlterou() {
        return nomeUsuarioAlterou;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }
}
