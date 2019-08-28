package com.example.service;


import com.example.entity.Book;
import com.example.entity.BookCategory;

import java.util.List;

public interface BookService {

    List<Book> findAllBook();

    List<BookCategory> findBookCategory();

    List<Book> findCategoryByBooksResult(Integer bookCategory);

    void addBook(Book book);

    void addBookCategory(BookCategory bookCategory);

    void deleteBookCategory(Integer bookCategoryId);

    void borrowBook(Integer bookId);
}
