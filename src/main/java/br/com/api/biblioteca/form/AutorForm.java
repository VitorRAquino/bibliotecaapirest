package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    @NotNull
    @NotEmpty
    private String nomeUsuario;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor converter(Usuario usuarioLogado) {
        return new Autor(nome, usuarioLogado);
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}
