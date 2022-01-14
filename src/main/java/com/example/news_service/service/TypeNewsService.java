package com.example.news_service.service;

import com.example.news_service.entity.TypeNews;

import java.util.List;

public interface TypeNewsService {

    public List<TypeNews> getAllTypeNews();

    public void saveTypeNews(TypeNews typeNew);

    public TypeNews getTypeNews(long id);

    public void deleteTypeNews(long id);
}
