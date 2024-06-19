package com.donato.Junior.test.service;

import com.donato.Junior.test.model.GitRepositoryDomain;
import com.donato.Junior.test.model.GitRepositoryObjectMother;
import com.donato.Junior.test.model.GitRepositoryResponse;
import com.donato.Junior.test.model.GitRepositorySearchDomain;
import com.donato.Junior.test.repository.GitClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.FileNotFoundException;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GitRepositoryServiceTest {
    @Mock
    private GitClient repository;
    @InjectMocks
    private GitRepositoryService target;

    private GitRepositoryDomain gitRepositoryDomain;
    private GitRepositoryResponse gitRepositoryResponse;

    private GitRepositorySearchDomain gitRepositorySearchDomain;

    private String username;

    private String name;

    @BeforeEach
    public void setup(){
        gitRepositoryDomain = GitRepositoryObjectMother.gitRepositoryDomain();
        gitRepositoryResponse = GitRepositoryObjectMother.gitRepositoryResponse();
        username = "TestUsername";
        name = "TestName";
        gitRepositorySearchDomain = GitRepositoryObjectMother.gitRepositorySearchDomain();
    }

    @Test
    public void shouldListAllRepositoryByUser(){
        when(repository.getAllGitRepositoryByUser(username))
                .thenReturn(List.of(gitRepositoryDomain));

        List<GitRepositoryResponse> res =target.listAllRepositoryByUser(username);

        assertEquals(res, List.of(gitRepositoryResponse));
        verify(repository).getAllGitRepositoryByUser(username);
    }
    @Test
    public void shouldListAllRepositoryByName(){
        when(repository.getRepositoryByName(name+" in:name"))
                .thenReturn(gitRepositorySearchDomain);

        List<GitRepositoryResponse> res = target.listAllRepositoryByName(name);

        assertEquals(res, List.of(gitRepositoryResponse));
        verify(repository).getRepositoryByName(name+" in:name");
    }
    @Test
    public void shouldCreateCsvByUsername() throws FileNotFoundException {
        when(repository.getAllGitRepositoryByUser(username))
                .thenReturn(List.of(gitRepositoryDomain));
        target.createCsvByUsername(username);

        verify(repository).getAllGitRepositoryByUser(username);
    }

    @Test
    public void shouldCreateCsvByRepositoryName() throws FileNotFoundException{
        when(repository.getRepositoryByName(name+" in:name"))
                .thenReturn(gitRepositorySearchDomain);

        target.createCsvByRepositoryName(name);

        verify(repository).getRepositoryByName(name+" in:name");
    }
}
