package com.donato.Junior.test.repository;

import com.donato.Junior.test.model.GitRepositoryDomain;
import com.donato.Junior.test.model.GitRepositorySearchDomain;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://api.github.com", name = "gitApi")
public interface GitClient {
    @GetMapping(value = "/users/{username}/repos")
    List<GitRepositoryDomain> getAllGitRepositoryByUser(@PathVariable(name = "username") String username);
    @GetMapping("/search/repositories")
    GitRepositorySearchDomain getRepositoryByName(@RequestParam("q") String query);
}
