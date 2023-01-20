package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select p from Usuario p WHERE p.nome = :nome")
    List<Usuario> findByUsuarioNome(String nome);
    Usuario findByNome(String nome);
}
