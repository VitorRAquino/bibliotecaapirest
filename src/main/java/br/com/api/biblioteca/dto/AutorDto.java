package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Autor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    private String nomeUsuario;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataCriacao = autor.getDataCriacao();
        this.nomeUsuario = autor.getUsuarioCriou().getNome();
    }

    public static List<AutorDto> converter(List<Autor> autores) {
        return autores.stream().map(AutorDto::new).collect(Collectors.toList());
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
