package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Cliente;
import br.com.api.biblioteca.modelo.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteForm {
    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String telefone;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private String documentoIdentidade;

    @NotNull
    @NotEmpty
    @Length(min = 3)
    private LocalDate dataNascimento;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String email;


    public String getTelefone() {
        return telefone;
    }

    String nomeUsuario;

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumentoIdentidade() {
        return documentoIdentidade;
    }

    public void setDocumentoIdentidade(String documentoIdentidade) {
        this.documentoIdentidade = documentoIdentidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente converter(Usuario usuarioLogado) {
        return new Cliente(nome, email, telefone, dataNascimento, documentoIdentidade, usuarioLogado);
    }

}
