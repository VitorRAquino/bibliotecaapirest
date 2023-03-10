package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {


    List<Emprestimo> findByLivroNome(String nome);
}
