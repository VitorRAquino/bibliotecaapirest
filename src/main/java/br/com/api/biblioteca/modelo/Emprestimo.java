package br.com.api.biblioteca.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataLimite;
    private LocalDateTime dataEntrega;
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status = StatusEmprestimo.ATIVO;

    @ManyToOne
    @JoinColumn(name = "usuario_alterou_id")
    private Usuario usuarioAlterou;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioCriou;
    @ManyToOne
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuarioAlterou() {
        return usuarioAlterou;
    }

    public void setUsuarioAlterou(Usuario usuarioAlterou) {
        this.usuarioAlterou = usuarioAlterou;
    }

    public Emprestimo(LocalDateTime dataLimite, Livro livro, Usuario usuarioCriou, Cliente cliente) {
        this.usuarioCriou = usuarioCriou;
        this.livro = livro;
        this.dataLimite = dataLimite;
        this.cliente = cliente;
    }

    public Emprestimo() {

    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Emprestimo other = (Emprestimo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setUsuarioCriou(Usuario usuarioCriou) {
        this.usuarioCriou = usuarioCriou;
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

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuarioCriou() {
        return usuarioCriou;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }


}