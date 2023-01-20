package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.repository.EmprestimoRepository;
import br.com.api.biblioteca.repository.LivroRepository;

import java.time.LocalDateTime;

public class AtualizacaoEmprestimoForm {

    private Long id;
    private LocalDateTime dataLimite;
    private LocalDateTime dataEntrega;


    public Emprestimo atualizar(Long id, EmprestimoRepository emprestimoRepository) {
        Emprestimo emprestimo = emprestimoRepository.getOne(id);
        emprestimo.setDataEntrega(this.dataEntrega);
        emprestimo.setDataLimite(this.dataLimite);

        return emprestimo;
    }
}
