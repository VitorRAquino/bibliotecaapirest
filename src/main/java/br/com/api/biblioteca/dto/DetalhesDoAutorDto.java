package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Autor;

import java.time.LocalDateTime;

public class DetalhesDoAutorDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;


    public DetalhesDoAutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataCriacao = autor.getDataCriacao();
        this.nomeUsuario = autor.getUsuario().getNome();
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
}
