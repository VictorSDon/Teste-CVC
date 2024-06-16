package com.donato.Junior.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GitRepositorySearchDomain {
    private Integer total_count;
    private Boolean incomplete_results;
    private List<GitRepositoryDomain> items;
}
