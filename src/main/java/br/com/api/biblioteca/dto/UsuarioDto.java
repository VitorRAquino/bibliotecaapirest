package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Usuario;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDto {

    private Long id;

    private String nome;

    private String email;

    private LocalDateTime dataCriacao;

    private String senha;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataCriacao = usuario.getDataCriacao();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
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
