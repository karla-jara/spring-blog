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
}
