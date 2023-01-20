package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);

    @Query("select p from Categoria p WHERE p.nome = :nome")
    List<Categoria> findByCategoriaNome(String nome);
}
