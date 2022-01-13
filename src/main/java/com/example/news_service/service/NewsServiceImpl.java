package com.example.news_service.service;

import com.example.news_service.dao.NewsDAO;
import com.example.news_service.dao.TypeNewsDAO;
import com.example.news_service.entity.News;
import com.example.news_service.entity.TypeNews;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDAO newsDAO;

    @Override
    @Transactional
    public List<News> getAllNews() {
        return newsDAO.getAllNews();
    }

    @Override
    @Transactional
    public void saveNews(News news) {
        newsDAO.saveNews(news);

    }

    @Override
    @Transactional
    public News getNews(long id) {
        return newsDAO.getNews(id);
    }

    @Override
    @Transactional
    public void deleteNews(long id) {
        newsDAO.deleteNews(id);

    }
}