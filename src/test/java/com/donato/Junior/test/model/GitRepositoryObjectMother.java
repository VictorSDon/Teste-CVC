package com.donato.Junior.test.model;

import java.util.List;

public class GitRepositoryObjectMother {
    public static GitRepositoryDomain gitRepositoryDomain(){
        return GitRepositoryDomain.builder()
                .full_name("UNIT TEST").description("testing")
                .html_url("www.unittest.com").created_at("01/01/2024")
                .updated_at("17/06/2024").stargazers_count(15).language("JAVA").build();
    }

    public static GitRepositoryResponse gitRepositoryResponse(){
        return GitRepositoryResponse.builder()
                .nomeDoRepositorio("UNIT TEST").descricao("testing")
                .urlDoRepositorio("www.unittest.com").dataDeCriacao("01/01/2024")
                .dataDaUltimaAtualizacao("17/06/2024").numeroDeEstrelas(15).linguagem("JAVA").build();
    }

    public static GitRepositorySearchDomain gitRepositorySearchDomain(){
        return GitRepositorySearchDomain.builder()
                .items(List.of(gitRepositoryDomain()))
                .incomplete_results(false)
                .total_count(12).build();
    }
}
