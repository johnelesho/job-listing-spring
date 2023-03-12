package com.elsoft.springjoblisting.repositories;

import com.elsoft.springjoblisting.dtos.SearchDto;
import com.elsoft.springjoblisting.models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface SearchRepository {
 List<JobPost> findBySearchTerm(SearchDto body);
}
