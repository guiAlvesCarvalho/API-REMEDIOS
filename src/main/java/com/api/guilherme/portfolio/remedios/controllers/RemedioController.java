package com.api.guilherme.portfolio.remedios.controllers;

import com.api.guilherme.portfolio.remedios.remedio.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DTODetalhamentoRemedio> cadastrar(@RequestBody @Valid DTOCadastroRemedio dados, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dados);
        repository.save(remedio);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DTODetalhamentoRemedio(remedio));
    }

    @GetMapping
    public ResponseEntity<List<DTOListagemRemedio>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DTOListagemRemedio::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DTODetalhamentoRemedio> atualizar(@RequestBody @Valid DTOAtualizarRemedio dados) {
        Remedio remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformações(dados);

        return ResponseEntity.ok(new DTODetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        Remedio remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        Remedio remedio = repository.getReferenceById(id);
        remedio.ativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DTODetalhamentoRemedio> detalhar(@PathVariable Long id) {
        Remedio remedio = repository.getReferenceById(id);

        return ResponseEntity.ok(new DTODetalhamentoRemedio(remedio));
    }

}
