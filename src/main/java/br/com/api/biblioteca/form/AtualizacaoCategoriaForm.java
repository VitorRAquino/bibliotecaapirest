package br.com.api.biblioteca.form;

import br.com.api.biblioteca.config.security.AutenticacaoService;
import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.CategoriaRepository;

public class AtualizacaoCategoriaForm {

    private Long id;

    private AutenticacaoService autenticacaoService;

    private String nome;

    public Categoria atualizar(Long id, CategoriaRepository categoriaRepository, Usuario usuarioLogado) {
        Categoria categoria = categoriaRepository.getOne(id);
        categoria.setNome(this.nome);
        categoria.setUsuarioAlterou(usuarioLogado);

        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
