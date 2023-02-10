package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.StatusEmprestimo;
import br.com.api.biblioteca.repository.EmprestimoRepository;

import java.time.LocalDateTime;

public class AtualizacaoEmprestimoForm {

    private Long id;
    private LocalDateTime dataLimite;
    private LocalDateTime dataEntrega;
    private StatusEmprestimo statusEmprestimo;
    private LocalDateTime dataAlteracao;

    private String nomeLivro;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;

    private String nomeCliente;



    public Emprestimo atualizar(Long id, EmprestimoRepository emprestimoRepository) {
        Emprestimo emprestimo = emprestimoRepository.getOne(id);
        emprestimo.setDataEntrega(this.dataEntrega);
        emprestimo.setDataLimite(this.dataLimite);
        emprestimo.setDataAlteracao(this.dataAlteracao);
        emprestimo.setStatus(this.statusEmprestimo);
        emprestimo.getLivro().setNome(nomeLivro);
        emprestimo.getUsuarioCriou().setNome(nomeUsuario);
        emprestimo.getUsuarioAlterou().setNome(nomeUsuarioAlterou);
        emprestimo.getCliente().setNome(nomeCliente);

        return emprestimo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeUsuarioAlterou(String nomeUsuarioAlterou) {
        this.nomeUsuarioAlterou = nomeUsuarioAlterou;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
}
