package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.UsuarioRepository;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

public class CategoriaForm {
    @NotNull @NotEmpty @Length(min = 5)
    private String nome;
    @NotNull @NotEmpty
    private String nomeUsuario;


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
        return new Categoria(nome, usuario);
    }
}
