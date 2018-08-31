package com.dds.mybatis;


import org.apache.ibatis.annotations.AutomapConstructor;

import java.util.List;

public class Blog {

    private int id;
    private String name;
    private String text;
    private Author author;
    private List<Post> posts;

    @AutomapConstructor
    public Blog(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
