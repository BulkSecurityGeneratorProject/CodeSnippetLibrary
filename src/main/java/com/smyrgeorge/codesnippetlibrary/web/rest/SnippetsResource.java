package com.smyrgeorge.codesnippetlibrary.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.smyrgeorge.codesnippetlibrary.domain.Snippet;
import com.smyrgeorge.codesnippetlibrary.repository.SnippetRepository;
import com.smyrgeorge.codesnippetlibrary.security.AuthoritiesConstants;
import com.smyrgeorge.codesnippetlibrary.service.SnippetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by smyrgeorge on 7/5/16.
 */
@Controller
@RequestMapping("/api")
public class SnippetsResource {


    private final Logger log = LoggerFactory.getLogger(SnippetsResource.class);


    @Inject
    private SnippetService snippetService;


    @RequestMapping(value = "/snippets/{username}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<List<Snippet>> getAllSnippetsByUsername(@PathVariable String username) {

        List<Snippet> userSnippets = snippetService.findAllByCreatedBy(username);
        return new ResponseEntity<>(userSnippets, HttpStatus.OK);
    }
}
