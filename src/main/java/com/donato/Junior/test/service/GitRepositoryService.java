package com.donato.Junior.test.service;


import com.donato.Junior.test.model.GitRepositoryDomain;
import com.donato.Junior.test.model.GitRepositoryResponse;
import com.donato.Junior.test.repository.GitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    public List<GitRepositoryResponse> listAllRepositoryByName(String name){
        List<GitRepositoryDomain> domain  = repository.getRepositoryByName(name+" in:name").getItems();
        List<GitRepositoryResponse> response =domain.stream()
                .map(this :: parseDomainToResponse)
                .toList();
        return response;
    }

    public GitRepositoryResponse parseDomainToResponse(GitRepositoryDomain domain){
        return GitRepositoryResponse.builder()
                .nomeDoRepositorio(domain.getFull_name())
                .descricao(domain.getDescription())
                .dataDeCriacao(domain.getCreated_at())
                .dataDaUltimaAtualizacao(domain.getUpdated_at())
                .urlDoRepositorio(domain.getHtml_url())
                .numeroDeEstrelas(domain.getStargazers_count())
                .linguagem(domain.getLanguage()).build();
    }
    public void createCsvByUsername(String username) throws FileNotFoundException {
        File csvRepository = new File ("RepositoryByUser.csv");
        PrintWriter out = new PrintWriter(csvRepository);

        List<GitRepositoryResponse> toSave = listAllRepositoryByUser(username);

        for(GitRepositoryResponse gitRepository : toSave){
            out.printf("%s, %s, %s, %s, %s, %d, %s\n", gitRepository.getNomeDoRepositorio(),
                    gitRepository.getDescricao(), gitRepository.getUrlDoRepositorio(),
                    gitRepository.getDataDeCriacao(), gitRepository.getDataDaUltimaAtualizacao(),
                    gitRepository.getNumeroDeEstrelas(), gitRepository.getLinguagem());
        }
        out.close();
    }
    public void createCsvByRepositoryName(String repositoryName) throws FileNotFoundException {
        File csvRepository = new File ("RepositoryByName.csv");
        PrintWriter out = new PrintWriter(csvRepository);

        List<GitRepositoryResponse> toSave = listAllRepositoryByName(repositoryName);

        for(GitRepositoryResponse gitRepository : toSave){
            out.printf("%s, %s, %s, %s, %s, %d, %s\n", gitRepository.getNomeDoRepositorio(),
                    gitRepository.getDescricao(), gitRepository.getUrlDoRepositorio(),
                    gitRepository.getDataDeCriacao(), gitRepository.getDataDaUltimaAtualizacao(),
                    gitRepository.getNumeroDeEstrelas(), gitRepository.getLinguagem());
        }
        out.close();
    }
}
