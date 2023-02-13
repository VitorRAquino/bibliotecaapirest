package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String senha;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario converter(Usuario usuarioLogado) {
        return new Usuario(nome, senha, email, usuarioLogado);
    }

}
