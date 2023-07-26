package com.api.guilherme.portfolio.remedios.remedio;

import jakarta.validation.constraints.NotNull;

public record DTOAtualizarRemedio(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio
) {

}
