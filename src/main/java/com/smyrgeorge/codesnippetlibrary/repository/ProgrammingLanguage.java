package com.smyrgeorge.codesnippetlibrary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by smyrgeorge on 7/11/16.
 */
public interface ProgrammingLanguage extends MongoRepository<ProgrammingLanguage, String> {

    List<ProgrammingLanguage> findAll();
}
