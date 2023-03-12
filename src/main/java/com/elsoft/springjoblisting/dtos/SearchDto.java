package com.elsoft.springjoblisting.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class SearchDto {
    @NotBlank
    private String search;
    @NotNull
    private List<String> searchPath;

    @NotNull
    private String sort;
    private Long sortOrder = 1L;
    @Builder.Default
    private Long limit = 5L;
}
