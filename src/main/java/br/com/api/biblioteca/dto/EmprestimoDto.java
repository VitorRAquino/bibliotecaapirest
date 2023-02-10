package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Emprestimo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoDto {

    private Long id;

    private String nomeLivro;

    private String nomeUsuario;

    private LocalDateTime dataCriacao;

    private String nomeCliente;

    public EmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataCriacao = emprestimo.getDataCriacao();
        this.nomeLivro = emprestimo.getLivro().getNome();
        this.nomeUsuario = emprestimo.getUsuarioCriou().getNome();
        this.nomeCliente = emprestimo.getCliente().getNome();
    }

    public static List<EmprestimoDto> converter(List<Emprestimo> emprestimos) {
        return emprestimos.stream().map(EmprestimoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
