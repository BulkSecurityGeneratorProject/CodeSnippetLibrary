package com.smyrgeorge.codesnippetlibrary.config.dbmigrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Creates the initial database setup
 */
@ChangeLog(order = "001")
public class InitialSetupMigration {

    private Map<String, String>[] authoritiesUser = new Map[]{new HashMap<>()};

    private Map<String, String>[] authoritiesAdminAndUser = new Map[]{new HashMap<>(), new HashMap<>()};

    {
        authoritiesUser[0].put("_id", "ROLE_USER");
        authoritiesAdminAndUser[0].put("_id", "ROLE_USER");
        authoritiesAdminAndUser[1].put("_id", "ROLE_ADMIN");
    }

    @ChangeSet(order = "01", author = "initiator", id = "01-addAuthorities")
    public void addAuthorities(DB db) {
        DBCollection authorityCollection = db.getCollection("csl_authority");
        authorityCollection.insert(
            BasicDBObjectBuilder.start()
                .add("_id", "ROLE_ADMIN")
                .get());
        authorityCollection.insert(
            BasicDBObjectBuilder.start()
                .add("_id", "ROLE_USER")
                .get());
    }

    @ChangeSet(order = "02", author = "initiator", id = "02-addUsers")
    public void addUsers(DB db) {
        DBCollection usersCollection = db.getCollection("csl_user");
        usersCollection.createIndex("login");
        usersCollection.createIndex("email");
        usersCollection.insert(BasicDBObjectBuilder.start()
            .add("_id", "user-0")
            .add("login", "admin")
            .add("password", "$2a$10$gSAhZrxMllrbgj/kkK9UceBPpChGWJA7SYIb1Mqo.n5aNLq1/oRrC")
            .add("first_name", "admin")
            .add("last_name", "Administrator")
            .add("email", "admin@localhost")
            .add("activated", "true")
            .add("lang_key", "en")
            .add("created_by", "system")
            .add("created_date", new Date())
            .add("authorities", authoritiesAdminAndUser)
            .get()
        );
        usersCollection.insert(BasicDBObjectBuilder.start()
            .add("_id", "user-1")
            .add("login", "user")
            .add("password", "$2a$10$VEjxo0jq2YG9Rbk2HmX9S.k1uZBGYUHdUcid3g/vfiEl7lwWgOH/K")
            .add("first_name", "")
            .add("last_name", "User")
            .add("email", "user@localhost")
            .add("activated", "true")
            .add("lang_key", "en")
            .add("created_by", "system")
            .add("created_date", new Date())
            .add("authorities", authoritiesUser)
            .get()
        );
    }

    @ChangeSet(order = "03", author = "initiator", id = "03-addProgrammingLanguages")
    public void addProgrammingLanguages(DB db) {
        DBCollection programmingLanguages = db.getCollection("csl_programming_language");
        programmingLanguages.insert(BasicDBObjectBuilder.start()
            .add("_id", "plain_text")
            .add("title", "Plain Text")
            .get()
        );
        programmingLanguages.insert(BasicDBObjectBuilder.start()
            .add("_id", "java")
            .add("title", "Java")
            .get()
        );
        programmingLanguages.insert(BasicDBObjectBuilder.start()
            .add("_id", "c")
            .add("title", "C")
            .get()
        );
    }

    @ChangeSet(order = "04", author = "initiator", id = "04-addSampleSnippets")
    public void addSampleSnippets(DB db) {
        DBCollection publicSnippets = db.getCollection("csl_snippets");
        publicSnippets.createIndex("title");
        publicSnippets.insert(BasicDBObjectBuilder.start()
            .add("_id", "snip-0")
            .add("title", "First Sample Snippet (Docker rename container)")
            .add("description", "This is a sample snippet." +
                "Docker rename container" +
                "The docker rename command allows the container to be renamed to a different name.")
            .add("code", "Usage: docker rename [OPTIONS] OLD_NAME NEW_NAME\n" +
                "\n" +
                "Rename a container\n" +
                "\n" +
                "  --help          Print usage")
            .add("programming_language", "Plain Text")
            .add("url", "https://docs.docker.com/engine/reference/commandline/rename/")
            .add("created_by", "admin")
            .add("created_date", new Date())
            .add("public", false)
            .get()
        );
    }


}
