package com.microservice.quiz_service.entity;

public class QuizDto {
    String categoryName;
    Integer numQ;
    String title;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public void setNumQ(Integer numQ) {
        this.numQ = numQ;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getNumQ() {
        return numQ;
    }


    public QuizDto(String categoryName, Integer numQ, String title) {
        this.categoryName = categoryName;
        this.numQ = numQ;
        this.title = title;
    }

//    public QuizDto() {
//    }
}
