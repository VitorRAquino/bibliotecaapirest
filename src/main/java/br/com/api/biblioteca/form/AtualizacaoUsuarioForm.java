package br.com.api.biblioteca.form;

import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.AutorRepository;
import br.com.api.biblioteca.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {

    private Long id;

    private String email;

    private String senha;

    private String nome;

    public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.getOne(id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);

        return usuario;
    }
}
