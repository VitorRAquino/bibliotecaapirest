package br.com.api.biblioteca.controller;

import br.com.api.biblioteca.dto.ClienteDto;
import br.com.api.biblioteca.dto.DetalhesDoClienteDto;
import br.com.api.biblioteca.form.AtualizacaoClienteForm;
import br.com.api.biblioteca.form.ClienteForm;
import br.com.api.biblioteca.modelo.Cliente;
import br.com.api.biblioteca.repository.ClienteRepository;
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
@RequestMapping("/clientes")
@Api(tags = "Cliente", description = "Gerencie Cliente")
public class ClienteController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    @Transactional
    public List<ClienteDto> lista(String nome) {
        if (nome == null) {
            List<Cliente> cliente = clienteRepository.findAll();
            return ClienteDto.converter(cliente);
        } else {
            List<Cliente> cliente = clienteRepository.findByClienteNome(nome);
            return ClienteDto.converter(cliente);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter(usuarioRepository);

        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesDoClienteDto> detalhar(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(new DetalhesDoClienteDto(cliente.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoClienteForm form) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = form.atualizar(id, clienteRepository);
            return ResponseEntity.ok(new ClienteDto(cliente));
        }

        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
