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

//    this function is retrieving all the repositories from a specific user,
//    using the GitClient then parsing it to the response model
    public List<GitRepositoryResponse> listAllRepositoryByUser(String username){
        List<GitRepositoryDomain> domainList = repository.getAllGitRepositoryByUser(username);
        List<GitRepositoryResponse> response =domainList.stream()
                .map(this :: parseDomainToResponse)
                .toList();
        return response;

    }
//    this function is retrieving all the repositories with the matching name,
//    using the GitClient then parsing it to the response model

    public List<GitRepositoryResponse> listAllRepositoryByName(String name){
        List<GitRepositoryDomain> domain  = repository.getRepositoryByName(name+" in:name").getItems();
        List<GitRepositoryResponse> response =domain.stream()
                .map(this :: parseDomainToResponse)
                .toList();
        return response;
    }

//   function created to standardize conversion
    private GitRepositoryResponse parseDomainToResponse(GitRepositoryDomain domain){
        return GitRepositoryResponse.builder()
                .nomeDoRepositorio(domain.getFull_name())
                .descricao(domain.getDescription())
                .dataDeCriacao(domain.getCreated_at())
                .dataDaUltimaAtualizacao(domain.getUpdated_at())
                .urlDoRepositorio(domain.getHtml_url())
                .numeroDeEstrelas(domain.getStargazers_count())
                .linguagem(domain.getLanguage()).build();
    }

//this function creates a csv file with all the information defined on the function,
// for all the repositories of a specific user
    public void createCsvByUsername(String username) throws FileNotFoundException {
//        configuring the file writer
        File csvRepository = new File ("RepositoryByUser.csv");
        PrintWriter out = new PrintWriter(csvRepository);
//        retrieving the repositories to be written
        List<GitRepositoryResponse> toSave = listAllRepositoryByUser(username);
//writing the information on the file
        for(GitRepositoryResponse gitRepository : toSave){
            out.printf("%s, %s, %s, %s, %s, %d, %s\n", gitRepository.getNomeDoRepositorio(),
                    gitRepository.getDescricao(), gitRepository.getUrlDoRepositorio(),
                    gitRepository.getDataDeCriacao(), gitRepository.getDataDaUltimaAtualizacao(),
                    gitRepository.getNumeroDeEstrelas(), gitRepository.getLinguagem());
        }
//        finishing the process to save what has been written
        out.close();
    }
    //this function creates a csv file with all the information defined on the function,
// for all the repositories with the matching name
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
