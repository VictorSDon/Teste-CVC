package com.donato.Junior.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitRepositoryResponse {
    private String nomeDoRepositorio;
    private String descricao;
    private String urlDoRepositorio;
    private String dataDeCriacao;
    private String dataDaUltimaAtualizacao;
    private Integer numeroDeEstrelas;
    private String linguagem;
}
