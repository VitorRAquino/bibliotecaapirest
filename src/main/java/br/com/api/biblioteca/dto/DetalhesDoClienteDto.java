package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Cliente;
import br.com.api.biblioteca.modelo.StatusCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DetalhesDoClienteDto {

    private final LocalDate dataNascimento;
    private final StatusCliente status;
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String nomeUsuarioCriou;

    private String nomeUsuarioAlterou;


    public DetalhesDoClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.telefone = cliente.getTelefone();
        this.nome = cliente.getNome();
        this.dataCriacao = cliente.getDataCriacao();
        this.email = cliente.getEmail();
        this.dataAlteracao = cliente.getDataAlteracao();
        this.dataNascimento = cliente.getDataNascimento();
        this.status = cliente.getStatus();
        this.nomeUsuarioCriou = cliente.getUsuarioCriou().getNome();
        this.nomeUsuarioAlterou = cliente.getUsuarioAlterou().getNome();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public String getNomeUsuarioCriou() {
        return nomeUsuarioCriou;
    }

    public String getNomeUsuarioAlterou() {
        return nomeUsuarioAlterou;
    }
}
