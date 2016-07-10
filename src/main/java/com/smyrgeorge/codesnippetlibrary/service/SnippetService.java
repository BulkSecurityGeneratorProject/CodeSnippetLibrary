package com.smyrgeorge.codesnippetlibrary.service;

import com.smyrgeorge.codesnippetlibrary.domain.Snippet;
import com.smyrgeorge.codesnippetlibrary.repository.SnippetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by smyrgeorge on 7/11/16.
 */
@Service
public class SnippetService {

    private final Logger log = LoggerFactory.getLogger(SnippetService.class);

    @Inject
    private SnippetRepository snippetRepository;

    public List<Snippet> findAll() {
        return snippetRepository.findAll();
    }

    public List<Snippet> findAllByCreatedBy(String username) {
        return snippetRepository.findAllByCreatedBy(username);
    }
}
