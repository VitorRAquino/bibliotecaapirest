package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Cliente;
import br.com.api.biblioteca.modelo.StatusCliente;
import br.com.api.biblioteca.repository.ClienteRepository;

import java.time.LocalDateTime;

public class AtualizacaoClienteForm {

    private Long id;

    private String email;

    private String telefone;

    private String nome;
    private LocalDateTime dataAlteracao;

    private StatusCliente statusCliente;

    private String nomeUsuario;

    private String nomeUsuarioAlterou;

    public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
        Cliente cliente = clienteRepository.getOne(id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setTelefone(this.telefone);
        cliente.setDataAlteracao(this.dataAlteracao);
        cliente.setStatus(this.statusCliente);
        cliente.getUsuarioCriou().setNome(nomeUsuario);
        cliente.getUsuarioAlterou().setNome(nomeUsuarioAlterou);

        return cliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setStatusCliente(StatusCliente statusCliente) {
        this.statusCliente = statusCliente;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setNomeUsuarioAlterou(String nomeUsuarioAlterou) {
        this.nomeUsuarioAlterou = nomeUsuarioAlterou;
    }
}
