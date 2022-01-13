package com.example.news_service.service;

import com.example.news_service.entity.News;
import com.example.news_service.entity.TypeNews;

import java.util.List;

public interface NewsService {
    public List<News> getAllNews();

    public void saveNews(News news);

    public News getNews(long id);

    public void deleteNews(long id);
}
