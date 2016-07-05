package com.smyrgeorge.codesnippetlibrary.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.smyrgeorge.codesnippetlibrary.domain.UserSnippet;
import com.smyrgeorge.codesnippetlibrary.repository.UserSnippetRepository;
import com.smyrgeorge.codesnippetlibrary.security.AuthoritiesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by smyrgeorge on 7/5/16.
 */
@Controller
@RequestMapping("/api")
public class UserSnippetsResource {


    private final Logger log = LoggerFactory.getLogger(UserSnippetsResource.class);


    @Inject
    private UserSnippetRepository userSnippetRepository;


    @RequestMapping(value = "/user_snippets",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity<List<UserSnippet>> getAllUsersSnippets() {

        List<UserSnippet> userSnippets = userSnippetRepository.findAll();

        return new ResponseEntity<>(userSnippets, HttpStatus.OK);
    }
}
