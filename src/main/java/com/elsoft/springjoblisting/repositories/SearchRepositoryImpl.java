package com.elsoft.springjoblisting.repositories;

import com.elsoft.springjoblisting.dtos.SearchDto;
import com.elsoft.springjoblisting.models.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class SearchRepositoryImpl implements SearchRepository{

    final MongoClient client;

    final MongoConverter converter;

   @Value("${spring.data.mongodb.database:joblisting}")
    String dbName;

    @Override
    public List<JobPost> findBySearchTerm(@NotNull SearchDto searchBody ) {
        List<JobPost> posts = new ArrayList<>();


        MongoDatabase db = client.getDatabase(dbName);
        MongoCollection<Document> collection = db.getCollection("job_post");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", searchBody.getSearch())
                                        .append("path", searchBody.getSearchPath() ))),
                new Document("$sort",
                        new Document(searchBody.getSort(), searchBody.getSortOrder())),
                new Document("$limit", searchBody.getLimit())));
 ;
 result.forEach(document -> posts.add(converter.read(JobPost.class, document)));
 return posts;
    }
}
