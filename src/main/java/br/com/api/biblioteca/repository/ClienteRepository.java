package br.com.api.biblioteca.repository;

import br.com.api.biblioteca.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select p from Cliente p WHERE p.nome = :nome")
    List<Cliente> findByClienteNome(String nome);

    Cliente findByNome(String nome);
}
