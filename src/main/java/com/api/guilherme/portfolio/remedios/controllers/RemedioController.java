package com.api.guilherme.portfolio.remedios.controllers;

import com.api.guilherme.portfolio.remedios.remedio.DTOCadastroRemedio;
import com.api.guilherme.portfolio.remedios.remedio.DTOListagemRemedio;
import com.api.guilherme.portfolio.remedios.remedio.Remedio;
import com.api.guilherme.portfolio.remedios.remedio.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DTOCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<DTOListagemRemedio> listar() {
        return repository.findAll().stream().map(DTOListagemRemedio::new).toList();
    }

}
