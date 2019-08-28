package com.example.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    //出版社
    private String bookPublish;
    //类别
    private Integer bookCategory;
    private Double bookPrice;
    //介绍
    private String bookIntroduction;
    //图书的数量，当数量为>=0的时候可借
    private Integer BookAmount;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public Integer getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Integer bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public Integer getBookAmount() {
        return BookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        BookAmount = bookAmount;
    }
}
