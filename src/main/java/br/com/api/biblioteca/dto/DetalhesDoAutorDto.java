package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Autor;

import java.time.LocalDateTime;

public class DetalhesDoAutorDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;

    private LocalDateTime dataAlteracao;


    public DetalhesDoAutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataCriacao = autor.getDataCriacao();
        this.nomeUsuario = autor.getUsuarioCriou().getNome();
        this.nomeUsuarioAlterou = autor.getUsuarioAlterou().getNome();
        this.dataAlteracao = autor.getDataAlteracao();
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
