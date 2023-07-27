package com.api.guilherme.portfolio.remedios.remedio;

import java.time.LocalDate;

public record DTODetalhamentoRemedio(
        Long id,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,
        Boolean ativo) {

    public DTODetalhamentoRemedio(Remedio remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.getAtivo()
        );
    }
}
