package br.com.api.biblioteca.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "usuario_alterou_id")
    private Usuario usuarioAlterou;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriou;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Usuario getUsuarioAlterou() {
        return usuarioAlterou;
    }

    public void setUsuarioAlterou(Usuario usuarioAlterou) {
        this.usuarioAlterou = usuarioAlterou;
    }

    public Usuario getUsuarioCriou() {
        return usuarioCriou;
    }

    public void setUsuarioCriou(Usuario usuarioCriou) {
        this.usuarioCriou = usuarioCriou;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    public Livro(String nome, Categoria categoria, Autor autor, Usuario usuarioCriou) {
        this.nome = nome;
        this.categoria = categoria;
        this.autor = autor;
        this.usuarioCriou = usuarioCriou;
    }

    public Livro() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}