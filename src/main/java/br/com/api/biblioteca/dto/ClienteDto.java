package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto {

    private final LocalDate dataNascimento;
    private Long id;

    private String nome;

    private String email;

    private LocalDateTime dataCriacao;

    private String telefone;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataCriacao = cliente.getDataCriacao();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.dataNascimento = cliente.getDataNascimento();
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getTelefone() {
        return telefone;
    }
}
