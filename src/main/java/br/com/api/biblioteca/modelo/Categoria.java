package br.com.api.biblioteca.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Categoria {
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

    public Categoria(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuarioCriou = usuario;
    }

    public Categoria() {

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

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
}
