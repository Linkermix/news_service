package com.example.news_service.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "types")
@Data
public class TypeNews
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @Column(name = "color")
    private String color;
}
