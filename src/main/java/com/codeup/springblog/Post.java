package com.codeup.springblog;

public class Post {
    private String title;
    private String body;

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle(){
        return title;
    }

    public String getBody(){
        return body;
    }

    public void setTitle(){
        this.title = title;
    }

    public void setBody(){
        this.body = body;
    }



}
