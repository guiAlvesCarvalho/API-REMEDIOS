package com.api.guilherme.portfolio.remedios.controllers;

import com.api.guilherme.portfolio.remedios.remedio.DTOCadastroRemedio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    @PostMapping
    public void cadastrar(@RequestBody DTOCadastroRemedio dados) {

    }
}
