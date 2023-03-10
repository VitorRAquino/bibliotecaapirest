package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.config.security.AutenticacaoService;
import br.com.api.biblioteca.dto.CategoriaDto;
import br.com.api.biblioteca.dto.DetalhesDoCategoriaDto;
import br.com.api.biblioteca.form.AtualizacaoCategoriaForm;
import br.com.api.biblioteca.form.CategoriaForm;
import br.com.api.biblioteca.modelo.Categoria;
import br.com.api.biblioteca.repository.CategoriaRepository;
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
@RequestMapping("/categorias")
@Api(tags = "Categoria", description = "Gerencie Categoria")
public class CategoriaController {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutenticacaoService autenticacaoService;


    @GetMapping
    @Transactional
    public List<CategoriaDto> lista(String nome) {
        if (nome == null) {
            List<Categoria> categorias = categoriaRepository.findAll();
            return CategoriaDto.converter(categorias);
        } else {
            List<Categoria> categorias = categoriaRepository.findByCategoriaNome(nome);
            return CategoriaDto.converter(categorias);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form,
                                                  UriComponentsBuilder uriBuilder) {

        Categoria categoria = form.converter(autenticacaoService.getUsuarioLogado());

        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoCategoriaDto> detalhar(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoCategoriaDto(categoria.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCategoriaForm form) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            Categoria categoria = form.atualizar(id, categoriaRepository, autenticacaoService.getUsuarioLogado());
            return ResponseEntity.ok(new CategoriaDto(categoria));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            categoriaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
