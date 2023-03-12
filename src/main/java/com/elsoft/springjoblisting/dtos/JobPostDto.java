package com.elsoft.springjoblisting.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class JobPostDto {
    private String profile;
    private String desc;
    private int exp;
    private String techs;
}
