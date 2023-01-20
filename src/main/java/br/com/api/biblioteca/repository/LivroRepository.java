package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("select p from Livro p WHERE p.nome = :nome")
    List<Livro> findByLivroNome(String nome);

    Livro findByNome(String nome);
}