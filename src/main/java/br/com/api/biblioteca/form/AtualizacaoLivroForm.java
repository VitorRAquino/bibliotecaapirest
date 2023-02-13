package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.LivroRepository;

public class AtualizacaoLivroForm {

    private Long id;
    private String nome;

    private String nomeCategoria;

    private String nomeAutor;

    private String nomeUsuario;

    public Livro atualizar(Long id, LivroRepository livroRepository, Usuario usuarioLogado) {
        Livro livro = livroRepository.getOne(id);
        livro.setNome(nome);
        livro.getAutor().setNome(nomeAutor);
        livro.getCategoria().setNome(nomeCategoria);
        livro.setUsuarioAlterou(usuarioLogado);

        return livro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
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
}
