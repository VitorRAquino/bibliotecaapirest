package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.repository.LivroRepository;

public class AtualizacaoLivroForm {

    private Long id;
    private String nome;


    public Livro atualizar(Long id, LivroRepository livroRepository) {
        Livro livro = livroRepository.getOne(id);
        livro.setNome(this.nome);

        return livro;
    }
}
