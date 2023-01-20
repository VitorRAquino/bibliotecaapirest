package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.*;
import br.com.api.biblioteca.repository.AutorRepository;
import br.com.api.biblioteca.repository.CategoriaRepository;
import br.com.api.biblioteca.repository.LivroRepository;
import br.com.api.biblioteca.repository.UsuarioRepository;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

public class EmprestimoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nomeLivro;

    @NotNull @NotEmpty
    private String nomeUsuario;


    public Emprestimo converter(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        Livro livro = livroRepository.findByNome(nomeLivro);
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
        return new Emprestimo(livro, usuario);
    }
}
