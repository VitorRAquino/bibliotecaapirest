package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Livro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.dataCriacao = livro.getDataCriacao();
    }

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
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
}
