package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Usuario;

import java.time.LocalDateTime;

public class DetalhesDoUsuarioDto {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private String nomeUsuario;


    public DetalhesDoUsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.senha = usuario.getSenha();
        this.nome = usuario.getNome();
        this.dataCriacao = usuario.getDataCriacao();
        this.email = usuario.getEmail();
        this.dataAlteracao = usuario.getDataAlteracao();
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

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
}
