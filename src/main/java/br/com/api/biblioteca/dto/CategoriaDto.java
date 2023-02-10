package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Categoria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {

    private Long id;

    private String nome;

    private LocalDateTime dataCriacao;

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.dataCriacao = categoria.getDataCriacao();
    }

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
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

