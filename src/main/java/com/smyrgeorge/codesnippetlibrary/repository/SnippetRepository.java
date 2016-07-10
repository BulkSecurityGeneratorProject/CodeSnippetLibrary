package com.smyrgeorge.codesnippetlibrary.repository;


import com.smyrgeorge.codesnippetlibrary.domain.Snippet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by smyrgeorge on 7/5/16.
 */
public interface SnippetRepository extends MongoRepository<Snippet, String> {

    List<Snippet> findAll();

    List<Snippet> findAllByCreatedBy(String createdBy);

}
