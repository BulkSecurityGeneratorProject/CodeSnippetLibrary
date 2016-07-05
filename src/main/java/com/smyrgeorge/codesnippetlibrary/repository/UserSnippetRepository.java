package com.smyrgeorge.codesnippetlibrary.repository;

import com.smyrgeorge.codesnippetlibrary.domain.UserSnippet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by smyrgeorge on 7/5/16.
 */
public interface UserSnippetRepository extends MongoRepository<UserSnippet, String> {

    List<UserSnippet> findAll();

}
