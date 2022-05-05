package com.demo.entity;

public class Topic {
    private int id;
    private String title;
    private String url;
    private String view_count;

    public Topic(int id, String title, String url, String view_count) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.view_count = view_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", view_count='" + view_count + '\'' +
                '}';
    }
}
