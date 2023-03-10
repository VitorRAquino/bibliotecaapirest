package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.AutorRepository;
import br.com.api.biblioteca.repository.CategoriaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LivroForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;
    @NotNull
    @NotEmpty
    private String nomeCategoria;
    @NotNull
    @NotEmpty
    private String nomeAutor;

    @NotNull
    @NotEmpty
    private String nomeUsuario;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository, Usuario usuarioLogado) {
        Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
        Autor autor = autorRepository.findByNome(nomeAutor);
        return new Livro(nome, categoria, autor, usuarioLogado);
    }
}
