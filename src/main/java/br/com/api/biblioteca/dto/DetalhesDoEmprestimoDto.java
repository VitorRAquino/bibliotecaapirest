package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.modelo.StatusEmprestimo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoEmprestimoDto {

    private Long id;
    private LocalDateTime dataCriacao;
    private String nomeUsuario;
    private StatusEmprestimo status;
    private String nomeLivro;

    public DetalhesDoEmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataCriacao = emprestimo.getDataCriacao();
        this.nomeLivro = emprestimo.getLivro().getNome();
        this.nomeUsuario = emprestimo.getUsuario().getNome();
        this.status = emprestimo.getStatus();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }
}
