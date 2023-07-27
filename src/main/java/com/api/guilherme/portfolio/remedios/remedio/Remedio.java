package com.api.guilherme.portfolio.remedios.remedio;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "remedios")
@Table(name = "Remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private Boolean ativo;

    public Remedio(DTOCadastroRemedio dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInformações(@Valid DTOAtualizarRemedio dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.via() != null) {
            this.via = dados.via();
        }
        if (dados.nome() != null) {
            this.laboratorio = dados.laboratorio();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}