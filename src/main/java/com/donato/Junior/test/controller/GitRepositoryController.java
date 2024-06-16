package com.donato.Junior.test.controller;

import com.donato.Junior.test.model.GitRepositoryResponse;
import com.donato.Junior.test.service.GitRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<GitRepositoryResponse> response = service.getRepositoryByName(name);
        return ResponseEntity.ok(response);
    }
}
