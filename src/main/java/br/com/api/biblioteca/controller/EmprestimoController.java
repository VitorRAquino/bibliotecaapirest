package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.config.security.AutenticacaoService;
import br.com.api.biblioteca.dto.DetalhesDoEmprestimoDto;
import br.com.api.biblioteca.dto.EmprestimoDto;
import br.com.api.biblioteca.form.AtualizacaoEmprestimoForm;
import br.com.api.biblioteca.form.EmprestimoForm;
import br.com.api.biblioteca.modelo.Emprestimo;
import br.com.api.biblioteca.repository.ClienteRepository;
import br.com.api.biblioteca.repository.EmprestimoRepository;
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
@RequestMapping("/emprestimos")
@Api(tags = "Empréstimo", description = "Gerencie Empréstimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutenticacaoService autenticacaoService;


    @GetMapping
    @Transactional
    public List<EmprestimoDto> lista(String nome) {
        if (nome == null) {
            List<Emprestimo> emprestimos = emprestimoRepository.findAll();
            return EmprestimoDto.converter(emprestimos);
        } else {
            List<Emprestimo> emprestimos = emprestimoRepository.findByLivroNome(nome);
            return EmprestimoDto.converter(emprestimos);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EmprestimoDto> cadastrar(@RequestBody @Valid EmprestimoForm form, UriComponentsBuilder uriBuilder) {
        Emprestimo emprestimo = form.converter(livroRepository, autenticacaoService.getUsuarioLogado(), clienteRepository);

        emprestimoRepository.save(emprestimo);

        URI uri = uriBuilder.path("/emprestimos/{id}").buildAndExpand(emprestimo.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmprestimoDto(emprestimo));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoEmprestimoDto> detalhar(@PathVariable Long id) {
        Emprestimo emprestimo = emprestimoRepository.getOne(id);

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EmprestimoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEmprestimoForm form) {
        Optional<Emprestimo> optional = emprestimoRepository.findById(id);
        if (optional.isPresent()) {
            Emprestimo emprestimo = form.atualizar(id, emprestimoRepository, autenticacaoService.getUsuarioLogado());
            return ResponseEntity.ok(new EmprestimoDto(emprestimo));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        emprestimoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
