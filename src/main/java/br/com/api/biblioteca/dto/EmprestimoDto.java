package br.com.api.biblioteca.dto;

import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.Livro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoDto {

    private Long id;

    private LocalDateTime dataCriacao;

    public EmprestimoDto(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataCriacao = emprestimo.getDataCriacao();
    }

    public static List<EmprestimoDto> converter(List<Emprestimo> emprestimos) {
        return emprestimos.stream().map(EmprestimoDto::new).collect(Collectors.toList());
    }
}
