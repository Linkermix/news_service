package com.example.news_service.dao;


import com.example.news_service.dto.AllNewsWithTypesDTO;
import com.example.news_service.entity.News;

import java.util.List;

public interface NewsDAO {
    public List<News> getAllNews();
    
    public void saveNews(News typeNew);

    public News getNews(long id);

    public void deleteNews(long id);

    public List<AllNewsWithTypesDTO> getAllNewsWithTypes();
}
