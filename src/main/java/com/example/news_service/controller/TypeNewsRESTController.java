package com.example.news_service.controller;

import com.example.news_service.entity.TypeNews;
import com.example.news_service.exception_handling.IncorrectData;
import com.example.news_service.exception_handling.NoSuchElementException;
import com.example.news_service.service.TypeNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeNewsRESTController {

    @Autowired
    private TypeNewsService typeNewsService;

    @GetMapping("/typenews")
    public List<TypeNews> showAllTypeNews() {
        List<TypeNews> typeNews = typeNewsService.getAllTypeNews();

        return typeNews;
    }
    @GetMapping("/typenews/{id}")
    public TypeNews getTypeNews(@PathVariable int id) {
        TypeNews typeNew = typeNewsService.getTypeNews(id);
        if (typeNew==null) {
            throw new NoSuchElementException("There is no typenews with ID = " +
                    id + " in Database");
        }

        return typeNew;
    }
    @PostMapping("/typenews")
    public TypeNews addNewTypeNews(@RequestBody TypeNews typeNews) {

        typeNewsService.saveTypeNews(typeNews);
        return typeNews;
    }
    @DeleteMapping("/typenews/{id}")
    public String deleteTypeNews(@PathVariable int id) {

        typeNewsService.deleteTypeNews(id);
        return "TypeNew with ID = " + id + " was deleted";
    }
    @PutMapping("/typenews")
    public TypeNews updateTypeNews(@RequestBody TypeNews typeNews) {

        typeNewsService.saveTypeNews(typeNews);
        return typeNews;
    }
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NoSuchElementException exception){
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(Exception exception){
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
