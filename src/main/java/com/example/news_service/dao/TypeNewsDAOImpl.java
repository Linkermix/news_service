package com.example.news_service.dao;

import com.example.news_service.entity.TypeNews;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Data
public class TypeNewsDAOImpl implements TypeNewsDAO {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<TypeNews> getAllTypeNews() {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("from TypeNews",TypeNews.class);
        List<TypeNews> allTypeNews = query.getResultList();
        return allTypeNews;
    }

    @Override
    public void saveTypeNews(TypeNews typeNews) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(typeNews);
    }

    @Override
    public TypeNews getTypeNews(long id) {
        Session session = entityManager.unwrap(Session.class);
        TypeNews typeNews = session.get(TypeNews.class,id);
        return typeNews;
    }

    @Override
    public void deleteTypeNews(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from TypeNews where id =:typeNewsId");
        query.setParameter("typeNewsId",id);
        query.executeUpdate();
    }
}
