package com.example.news_service.service;

import com.example.news_service.dao.TypeNewsDAO;
import com.example.news_service.entity.TypeNews;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
public class TypeNewsServiceImpl implements TypeNewsService {

    @Autowired
    private TypeNewsDAO typeNewsDAO;

    @Override
    @Transactional
    public List<TypeNews> getAllTypeNews() {
        return typeNewsDAO.getAllTypeNews();
    }

    @Override
    @Transactional
    public void saveTypeNews(TypeNews typeNews) {
        typeNewsDAO.saveTypeNews(typeNews);

    }

    @Override
    @Transactional
    public TypeNews getTypeNews(long id) {
        return typeNewsDAO.getTypeNews(id);
    }

    @Override
    @Transactional
    public void deleteTypeNews(long id) {
        typeNewsDAO.deleteTypeNews(id);

    }
}
