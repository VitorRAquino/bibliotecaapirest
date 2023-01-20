package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.AutorRepository;

public class AtualizacaoAutorForm {

    private Long id;


    private String nome;

    private String nomeUsuario;


    public Autor atualizar(Long id, AutorRepository autorRepository) {
        Autor autor = autorRepository.getOne(id);
        autor.setNome(this.nome);
        autor.setUsuario(new Usuario(this.nomeUsuario));

        return autor;
    }
}
