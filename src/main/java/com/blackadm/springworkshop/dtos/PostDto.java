package com.blackadm.springworkshop.dtos;

import com.blackadm.springworkshop.domain.Post;

import java.util.Date;

public class PostDto {

    private String id;

    private Date date;
    private String title;
    private String body;
    private AuthorDto author;

    public PostDto() {
    }

    public PostDto(Post obj) {
        id = obj.getId();
        date = obj.getDate();
        title = obj.getTitle();
        body = obj.getBody();
        author = obj.getAuthor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public  void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
