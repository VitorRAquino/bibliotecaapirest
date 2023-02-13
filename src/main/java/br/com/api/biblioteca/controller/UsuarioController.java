package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.config.security.AutenticacaoService;
import br.com.api.biblioteca.dto.DetalhesDoUsuarioDto;
import br.com.api.biblioteca.dto.UsuarioDto;
import br.com.api.biblioteca.form.AtualizacaoUsuarioForm;
import br.com.api.biblioteca.form.UsuarioForm;
import br.com.api.biblioteca.modelo.Usuario;
import br.com.api.biblioteca.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuário", description = "Gerencie Usuário")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @GetMapping
    @Transactional
    public List<UsuarioDto> lista(String nome) {
        if (nome == null) {
            List<Usuario> usuarios = usuarioRepository.findAll();
            return UsuarioDto.converter(usuarios);
        } else {
            List<Usuario> usuarios = usuarioRepository.findByUsuarioNome(nome);
            return UsuarioDto.converter(usuarios);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
        Usuario usuario = form.converter(autenticacaoService.getUsuarioLogado());

        usuarioRepository.save(usuario);

        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoUsuarioDto> detalhar(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoUsuarioDto(usuario.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm form) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            Usuario usuario = form.atualizar(id, usuarioRepository, autenticacaoService.getUsuarioLogado());
            return ResponseEntity.ok(new UsuarioDto(usuario));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if (optional.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
