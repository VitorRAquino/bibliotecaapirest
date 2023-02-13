package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter(Usuario usuarioLogado) {

        return new Categoria(nome, usuarioLogado);
    }
}
