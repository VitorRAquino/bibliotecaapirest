package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.StatusEmprestimo;

import java.time.LocalDateTime;

public class DetalhesDoEmprestimoDto {

    private  String nomeUsuarioAlterou;
    private  LocalDateTime dataLimite;
    private  LocalDateTime dataEntrega;
    private  String nomeCliente;
    private Long id;
    private LocalDateTime dataCriacao;
    private String nomeUsuario;
    private StatusEmprestimo status;
    private String nomeLivro;
    private LocalDateTime dataAlteracao;

    public DetalhesDoEmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataCriacao = emprestimo.getDataCriacao();
        this.dataLimite = emprestimo.getDataLimite();
        this.dataEntrega = emprestimo.getDataEntrega();
        this.nomeCliente = emprestimo.getCliente().getNome();
        this.nomeLivro = emprestimo.getLivro().getNome();
        this.nomeUsuario = emprestimo.getUsuarioCriou().getNome();
        this.status = emprestimo.getStatus();
        this.dataAlteracao = emprestimo.getDataAlteracao();
        this.nomeUsuarioAlterou = emprestimo.getUsuarioAlterou().getNome();
    }

    public String getNomeUsuarioAlterou() {
        return nomeUsuarioAlterou;
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

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }
}