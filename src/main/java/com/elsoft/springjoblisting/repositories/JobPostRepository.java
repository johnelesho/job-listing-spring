package com.elsoft.springjoblisting.repositories;

import com.elsoft.springjoblisting.models.JobPost;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository  extends MongoRepository<JobPost, ObjectId> {

}


