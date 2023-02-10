package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.AutorRepository;

public class AtualizacaoAutorForm {

    private Long id;


    private String nome;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;


    public Autor atualizar(Long id, AutorRepository autorRepository) {
        Autor autor = autorRepository.getOne(id);
        autor.setNome(this.nome);
        autor.getUsuarioCriou().setNome(nomeUsuario);
        autor.getUsuarioAlterou().setNome(nomeUsuarioAlterou);
        return autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setNomeUsuarioAlterou(String nomeUsuarioAlterou) {
        this.nomeUsuarioAlterou = nomeUsuarioAlterou;
    }
}
