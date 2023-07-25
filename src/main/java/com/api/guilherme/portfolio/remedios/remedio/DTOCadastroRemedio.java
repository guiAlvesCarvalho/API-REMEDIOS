package com.api.guilherme.portfolio.remedios.remedio;

public record DTOCadastroRemedio(
        String nome,
        Via via,
        String lote,
        String quantidade,
        String validade,
        Laboratorio laboratorio) {

}
