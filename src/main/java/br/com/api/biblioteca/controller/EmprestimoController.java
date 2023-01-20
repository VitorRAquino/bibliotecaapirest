package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.dto.DetalhesDoEmprestimoDto;
import br.com.api.biblioteca.dto.DetalhesDoLivroDto;
import br.com.api.biblioteca.dto.EmprestimoDto;
import br.com.api.biblioteca.dto.LivroDto;
import br.com.api.biblioteca.form.EmprestimoForm;
import br.com.api.biblioteca.form.LivroForm;
import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.modelo.Livro;
import br.com.api.biblioteca.repository.EmprestimoRepository;
import br.com.api.biblioteca.repository.LivroRepository;
import br.com.api.biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/emprestimos")
    @ResponseBody
    @Transactional
    public List<DetalhesDoEmprestimoDto> lista(String nome) {
        if(nome == null) {
            List<Emprestimo> emprestimos = emprestimoRepository.findAll();
            return DetalhesDoEmprestimoDto.converter(emprestimos);
        }else {
            List<Emprestimo> emprestimos = emprestimoRepository.findByLivroNome(nome);
            return DetalhesDoEmprestimoDto.converter(emprestimos);
        }
    }
    @PostMapping
    @Transactional
    public ResponseEntity<EmprestimoDto> cadastrar(@RequestBody @Valid EmprestimoForm form, UriComponentsBuilder uriBuilder) {
        Emprestimo emprestimo = form.converter(livroRepository, usuarioRepository);

        emprestimoRepository.save(emprestimo);

        URI uri = uriBuilder.path("/livros/{id}").buildAndExpand(emprestimo.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmprestimoDto(emprestimo));
    }
    @GetMapping("/{id}")
    @Transactional
    public DetalhesDoEmprestimoDto detalhar(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoRepository.getOne(id);

        return new DetalhesDoEmprestimoDto(emprestimo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
