package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.CategoriaRepository;

public class AtualizacaoCategoriaForm {

    private Long id;


    private String nome;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;

    public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getOne(id);
        categoria.setNome(this.nome);
        categoria.getUsuarioCriou().setNome(nomeUsuario);
        categoria.getUsuarioAlterou().setNome(nomeUsuarioAlterou);

        return categoria;
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
