package com.demo.entity;

import java.io.Serializable;

public class Img implements Serializable {
    private int id;
    private String imgurl;
    private int topicId;
    private int seq;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", imgurl='" + imgurl + '\'' +
                ", topicId=" + topicId +
                ", seq=" + seq +
                '}';
    }
}
