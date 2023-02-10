package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String nome);

    @Query("select p from Autor p WHERE p.nome = :nome")
    List<Autor> findByAutorNome(String nome);
}
