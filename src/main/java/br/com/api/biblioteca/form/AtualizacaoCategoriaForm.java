package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.CategoriaRepository;

public class AtualizacaoCategoriaForm {

    private Long id;


    private String nome;

    private String nomeUsuario;


    public Categoria atualizar(Long id, CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.getOne(id);
        categoria.setNome(this.nome);
        categoria.setUsuario(new Usuario(this.nomeUsuario));

        return categoria;
    }
}
