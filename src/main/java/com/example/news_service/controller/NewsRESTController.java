package com.example.news_service.controller;

import com.example.news_service.dto.AllNewsWithTypesDTO;
import com.example.news_service.entity.News;
import com.example.news_service.exception_handling.NoSuchElementException;
import com.example.news_service.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsRESTController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public List<News> showAllNews() {
        List<News> news = newsService.getAllNews();
        return news;
    }

    @GetMapping("/news/{id}")
    public News getNew(@PathVariable long id) {
        News news = newsService.getNews(id);

        if (news==null) {
            throw new NoSuchElementException("There is no news with ID = " +
                    id + " in Database");
        }
        return news;
    }

    @PostMapping("/news")
    public News addNewNews(@RequestBody News news) {
        newsService.saveNews(news);
        return news;
    }

    @DeleteMapping("/news/{id}")
    public String deleteNews(@PathVariable long id) {
        newsService.deleteNews(id);
        return "News with ID = " + id + " was deleted";
    }

    @PutMapping("/news")
    public News updateNews(@RequestBody News news) {
        newsService.saveNews(news);
        return news;
    }

    @GetMapping("/newstypes")
    public List<AllNewsWithTypesDTO> showAllNewsWithTypes() {
        List<AllNewsWithTypesDTO> newsWithTypes = newsService.getAllNewsWithTypes();
        return newsWithTypes;
    }
}
