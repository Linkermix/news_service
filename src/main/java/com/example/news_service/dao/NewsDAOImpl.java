package com.example.news_service.dao;

import com.example.news_service.entity.News;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Data
public class NewsDAOImpl implements NewsDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<News> getAllNews() {
        Query query = entityManager.createQuery("from New");
        List<News> allNews = query.getResultList();
        return allNews;
    }

    @Override
    public void saveNews(News news) {
        entityManager.merge(news);
    }

    @Override
    public News getNews(long id) {
        News news = entityManager.find(News.class, id);
        return null;
    }

    @Override
    public void deleteNews(long id) {
        Query query = entityManager.createQuery("delete from News where id =:NewsId");
        query.setParameter("NewsId",id);
        query.executeUpdate();
    }
}
