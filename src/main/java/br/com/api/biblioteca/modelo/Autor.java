package br.com.api.biblioteca.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }


    public Autor(String nome, Usuario usuario) {
        this.nome = nome;
    }

    public Autor() {

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
