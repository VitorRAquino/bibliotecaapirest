package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.UsuarioRepository;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

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

    public Usuario converter(UsuarioRepository usuarioRepository) {
        return new Usuario(nome, senha, email);
    }
}
