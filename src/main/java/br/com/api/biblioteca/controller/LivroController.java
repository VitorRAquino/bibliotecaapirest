package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.config.security.AutenticacaoService;
import br.com.api.biblioteca.dto.DetalhesDoLivroDto;
import br.com.api.biblioteca.dto.LivroDto;
import br.com.api.biblioteca.form.AtualizacaoLivroForm;
import br.com.api.biblioteca.form.LivroForm;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.repository.AutorRepository;
import br.com.api.biblioteca.repository.CategoriaRepository;
import br.com.api.biblioteca.repository.LivroRepository;
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
@RequestMapping("/livros")
@Api(tags = "Livro", description = "Gerencie Livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AutenticacaoService autenticacaoService;

    @GetMapping
    @Transactional
    public List<LivroDto> lista(String nome) {
        if (nome == null) {
            List<Livro> livros = livroRepository.findAll();
            return LivroDto.converter(livros);
        } else {
            List<Livro> livros = livroRepository.findByLivroNome(nome);
            return LivroDto.converter(livros);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form, UriComponentsBuilder uriBuilder) {
        Livro livro = form.converter(categoriaRepository, autorRepository, autenticacaoService.getUsuarioLogado());

        livroRepository.save(livro);

        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();
        return ResponseEntity.created(uri).body(new LivroDto(livro));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoLivroDto> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoLivroDto(livro.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LivroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLivroForm form) {
        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            Livro livro = form.atualizar(id, livroRepository, autenticacaoService.getUsuarioLogado());
            return ResponseEntity.ok(new LivroDto(livro));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent()) {
            livroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
