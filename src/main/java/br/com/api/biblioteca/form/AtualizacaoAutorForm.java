package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.AutorRepository;

public class AtualizacaoAutorForm {

    private Long id;


    private String nome;

    public Autor atualizar(Long id, AutorRepository autorRepository, Usuario usuarioLogado) {
        Autor autor = autorRepository.getOne(id);
        autor.setNome(this.nome);
        autor.setUsuarioAlterou(usuarioLogado);
        return autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
