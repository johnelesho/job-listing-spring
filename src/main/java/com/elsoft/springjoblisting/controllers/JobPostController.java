package com.elsoft.springjoblisting.controllers;


import com.elsoft.springjoblisting.dtos.SearchDto;
import com.elsoft.springjoblisting.models.JobPost;
import com.elsoft.springjoblisting.repositories.JobPostRepository;
import com.elsoft.springjoblisting.repositories.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jobs")
public class JobPostController {

    final JobPostRepository jobPostRepository;
    final SearchRepository searchRepository;




    @GetMapping("/")
    public List<JobPost> getALl(){
       return jobPostRepository.findAll();
    }
   @GetMapping("/search")
    public List<JobPost> search(@Valid @NotNull SearchDto dto){
       return searchRepository.findBySearchTerm(dto);
    }

    @PostMapping("/")
    public JobPost createPost(@RequestBody JobPost body){
        JobPost post = jobPostRepository.save(body);

        return post;
    }
}
