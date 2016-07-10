package com.smyrgeorge.codesnippetlibrary.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by smyrgeorge on 7/5/16.
 */
@Document(collection = "csl_snippets")
public class Snippet {

    @Id
    private String id;

    @NotNull
    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @NotNull
    @Field("code")
    private String code;

    @Field("programming_language")
    private String programmingLanguage;

    @Field("url")
    private String url;

    @Field("created_by")
    private String createdBy;

    @Field("created_day")
    private Date createdDay;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snippet snippet = (Snippet) o;

        if (!id.equals(snippet.id)) return false;
        if (!title.equals(snippet.title)) return false;
        if (description != null ? !description.equals(snippet.description) : snippet.description != null) return false;
        if (code != null ? !code.equals(snippet.code) : snippet.code != null) return false;
        if (programmingLanguage != null ? !programmingLanguage.equals(snippet.programmingLanguage) : snippet.programmingLanguage != null)
            return false;
        if (url != null ? !url.equals(snippet.url) : snippet.url != null) return false;
        if (createdBy != null ? !createdBy.equals(snippet.createdBy) : snippet.createdBy != null) return false;
        return createdDay != null ? createdDay.equals(snippet.createdDay) : snippet.createdDay == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (programmingLanguage != null ? programmingLanguage.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdDay != null ? createdDay.hashCode() : 0);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }
}
