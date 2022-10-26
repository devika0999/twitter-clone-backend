package com.nestdigital.twitter_backend.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostsModel {

    @Id
    @GeneratedValue

    private int id;
    private int userid;
    private  String message ;
    private  String postdate;

    public PostsModel(int id, int userid, String message, String postdate) {
        this.id = id;
        this.userid = userid;
        this.message = message;
        this.postdate = postdate;
    }

    public PostsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }
}
