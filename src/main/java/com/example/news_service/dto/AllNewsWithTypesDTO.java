package com.example.news_service.dto;

import lombok.Data;

import javax.persistence.*;


@Data
public class AllNewsWithTypesDTO {

    private String newsName;

    private String shortDesc;

    private String typeName;

    private String color;

}
