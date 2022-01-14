package com.example.news_service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
@Data
public class TypeNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String typeName;

    @Column(name = "color")
    private String typeColor;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "typeNews")
    private List<News> newsList;

    public void addNewsToTypeNews(News news) {
        if (newsList == null) {
            newsList = new ArrayList<>();
        }
        newsList.add(news);
        news.setTypeNews(this);
    }
}
