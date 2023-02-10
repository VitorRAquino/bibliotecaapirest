package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Cliente;
import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.ClienteRepository;
import br.com.api.biblioteca.repository.LivroRepository;
import br.com.api.biblioteca.repository.UsuarioRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EmprestimoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nomeLivro;

    @NotNull
    @NotEmpty
    private String nomeUsuario;

    @NotNull
    @NotEmpty
    private String nomeCliente;

    @NotNull
    @NotEmpty
    private LocalDateTime dataLimite;




    public Emprestimo converter(LivroRepository livroRepository, UsuarioRepository usuarioRepository, ClienteRepository clienteRepository) {
        Livro livro = livroRepository.findByNome(nomeLivro);
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario);
        Cliente cliente = clienteRepository.findByNome(nomeCliente);
        return new Emprestimo(dataLimite,livro, usuario);
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }
}
