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

//this class is responsible for executing get requests to the GitHub API
@FeignClient(url = "https://api.github.com", name = "gitApi")
public interface GitClient {

//    this request is listing all the repositories from a specific user
    @GetMapping(value = "/users/{username}/repos")
    List<GitRepositoryDomain> getAllGitRepositoryByUser(@PathVariable(name = "username") String username);

//    this request allows to query for specific parameters for all GitHub repositories
//    for an example - to search for repositories with a specific name, the "q" param,
//    should be: "{desiredName} in:name"
    @GetMapping("/search/repositories")
    GitRepositorySearchDomain getRepositoryByName(@RequestParam("q") String query);
}
