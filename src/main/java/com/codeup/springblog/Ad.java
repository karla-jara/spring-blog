package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //All ads have an ad.title
    @Column(nullable = false, length = 100)
    private String title;
    //All ads have an ad.description
    @Column(nullable = false)
    private String description;

    public Ad() {
    }

    public Ad(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;

    }
}
