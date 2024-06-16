package com.donato.Junior.test.service;


import com.donato.Junior.test.model.GitRepositoryDomain;
import com.donato.Junior.test.model.GitRepositoryResponse;
import com.donato.Junior.test.repository.GitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitRepositoryService {
    private final GitClient repository;

    public List<GitRepositoryResponse> listAllRepositoryByUser(String username){
        List<GitRepositoryDomain> domainList = repository.getAllGitRepositoryByUser(username);
        List<GitRepositoryResponse> response =domainList.stream()
                .map(this :: parseDomainToResponse)
                .toList();
        return response;

    }

    public List<GitRepositoryResponse> getRepositoryByName(String name){
        List<GitRepositoryDomain> domain  = repository.getRepositoryByName(name+" in:name").getItems();
        List<GitRepositoryResponse> response =domain.stream()
                .map(this :: parseDomainToResponse)
                .toList();
        return response;
    }

    public GitRepositoryResponse parseDomainToResponse(GitRepositoryDomain domain){
        return GitRepositoryResponse.builder()
                .nomeDoRepositorio(domain.getName())
                .descricao(domain.getDescription())
                .dataDeCriacao(domain.getCreated_at())
                .dataDaUltimaAtualizacao(domain.getUpdated_at())
                .numeroDeEstrelas(domain.getStargazers_count())
                .linguagem(domain.getLanguage()).build();
    }
}
