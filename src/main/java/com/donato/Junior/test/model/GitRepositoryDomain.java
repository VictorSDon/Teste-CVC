package com.donato.Junior.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//model that requests the data from the GitHub API
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitRepositoryDomain {
    private String full_name;
    private String description;
    private String html_url;
    private String created_at;
    private String updated_at;
    private Integer stargazers_count;
    private String language;
}
