package com.example.news_service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "full_desc")
    private String fullDesc;

    @OneToMany
    @Column(name = "type_id")
    private long typeId;

}
