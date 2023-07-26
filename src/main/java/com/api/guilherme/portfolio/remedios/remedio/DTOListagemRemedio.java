package com.api.guilherme.portfolio.remedios.remedio;

import java.time.LocalDate;

public record DTOListagemRemedio(String nome, Via via, String lote, Laboratorio laboratorio, LocalDate validade) {

    public DTOListagemRemedio(Remedio remedio) {
        this(remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}

