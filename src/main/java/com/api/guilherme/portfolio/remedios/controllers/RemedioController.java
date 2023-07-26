package com.api.guilherme.portfolio.remedios.controllers;

import com.api.guilherme.portfolio.remedios.remedio.DTOCadastroRemedio;
import com.api.guilherme.portfolio.remedios.remedio.Remedio;
import com.api.guilherme.portfolio.remedios.remedio.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DTOCadastroRemedio dados) {
        repository.save(new Remedio(dados));
    }
}
