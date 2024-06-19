package com.donato.Junior.test.controller;


import com.donato.Junior.test.service.GitRepositoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GitRepositoryController.class)
public class GitRepositoryControllerTest {

    @MockBean
    private GitRepositoryService gitRepositoryService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldListAllRepositoryByUser() throws Exception {
        mockMvc.perform(get("/git/username/testName")
                .accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(gitRepositoryService).listAllRepositoryByUser("testName");
    }
    @Test
    public void shouldGetRepositoryByName() throws Exception {
        mockMvc.perform(get("/git/repositoryName/Junior")
                        .accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(gitRepositoryService).listAllRepositoryByName("Junior");
    }
    @Test
    public void shouldCsvByUsername() throws Exception {
        mockMvc.perform(post("/git/username/csv/testName")
                .accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(gitRepositoryService).createCsvByUsername("testName");
    }
    @Test
    public void shouldCsvByRepositoryName() throws Exception {
        mockMvc.perform(post("/git/repositoryName/csv/testRepository")
                        .accept(MediaType.ALL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        verify(gitRepositoryService).createCsvByRepositoryName("testRepository");
    }

}

