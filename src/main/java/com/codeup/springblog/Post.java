package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;

    // constructors
    public Post(){
    }
    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    // getters
    public Long getId() {
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(){
        this.title = title;
    }
    public void setBody(){
        this.body = body;
    }
}
