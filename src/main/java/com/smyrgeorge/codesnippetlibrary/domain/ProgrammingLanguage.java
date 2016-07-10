package com.smyrgeorge.codesnippetlibrary.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * Created by smyrgeorge on 7/11/16.
 */
@Document(collection = "csl_programming_language")
public class ProgrammingLanguage {

    @Id
    private String id;

    @NotNull
    @Field("title")
    private String title;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgrammingLanguage that = (ProgrammingLanguage) o;

        if (!id.equals(that.id)) return false;
        return title.equals(that.title);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
