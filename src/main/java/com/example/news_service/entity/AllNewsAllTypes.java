package com.example.news_service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class AllNewsAllTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "NewsName")
    private String newsName;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "TypeName")
    private String typeName;

    @Column(name = "color")
    private String color;


}
