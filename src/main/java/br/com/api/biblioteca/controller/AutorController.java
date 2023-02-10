package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.dto.AutorDto;
import br.com.api.biblioteca.dto.DetalhesDoAutorDto;
import br.com.api.biblioteca.form.AtualizacaoAutorForm;
import br.com.api.biblioteca.form.AutorForm;
import br.com.api.biblioteca.modelo.Autor;
import br.com.api.biblioteca.repository.AutorRepository;
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
@RequestMapping("/autores")
@Api(tags = "Autor", description = "Gerencie Autor")
public class AutorController {


    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    @Transactional
    public List<AutorDto> lista(String nome) {
        if (nome == null) {
            List<Autor> autor = autorRepository.findAll();
            return AutorDto.converter(autor);
        } else {
            List<Autor> autor = autorRepository.findByAutorNome(nome);
            return AutorDto.converter(autor);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder) {
        Autor autor = form.converter(usuarioRepository);

        autorRepository.save(autor);

        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new AutorDto(autor));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoAutorDto> detalhar(@PathVariable Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoAutorDto(autor.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AutorDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoAutorForm form) {
        Optional<Autor> optional = autorRepository.findById(id);
        if (optional.isPresent()) {
            Autor autor = form.atualizar(id, autorRepository);
            return ResponseEntity.ok(new AutorDto(autor));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Autor> optional = autorRepository.findById(id);
        if (optional.isPresent()) {
            autorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
