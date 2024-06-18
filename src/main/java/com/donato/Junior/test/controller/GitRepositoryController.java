package com.donato.Junior.test.controller;

import com.donato.Junior.test.model.GitRepositoryResponse;
import com.donato.Junior.test.service.GitRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/git")
public class GitRepositoryController {
    private final GitRepositoryService service;
    @GetMapping("/username/{username}")
    public ResponseEntity<List<GitRepositoryResponse>> listAllRepositoryByUser(@PathVariable String username){
        List<GitRepositoryResponse> response = service.listAllRepositoryByUser(username);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/repositoryName/{name}")
    public ResponseEntity<List<GitRepositoryResponse>> getRepositoryByName(@PathVariable String name){
        List<GitRepositoryResponse> response = service.listAllRepositoryByName(name);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/username/csv/{username}")
    public ResponseEntity<Void> csvByUsername(@PathVariable String username) throws FileNotFoundException{
        service.createCsvByUsername(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/repositoryName/csv/{repositoryName}")
    public ResponseEntity<Void> csvByRepositoryName(@PathVariable String repositoryName) throws FileNotFoundException{
        service.createCsvByRepositoryName(repositoryName);
        return ResponseEntity.noContent().build();
    }
}
