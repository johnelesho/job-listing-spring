package com.elsoft.springjoblisting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "job_post")
public class JobPost {

    @Id
    private ObjectId id;
    private String profile;
    private String desc;
    private int exp;
    private List<String> techs;
}
