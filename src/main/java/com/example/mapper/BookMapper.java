package com.example.mapper;

import com.example.entity.Book;
import com.example.entity.BookCategory;
import com.example.entity.BorrowRecording;

import java.util.List;

public interface BookMapper {

    List<Book> findAllBook();

    List<BookCategory> findBookCategory();

    /**
     * 根据图书的列表查询图书
     * @param bookCategory
     * @return
     */
    List<Book> findCategoryByBooksResult(Integer bookCategory);

    void addBook(Book book);

    void addBookCategory(BookCategory bookCategory);

    void deleteBookCategory(Integer bookCategoryId);

    /**
     * 根据bookid查询bookname
     */
    String findBookIdByBookName(Integer book_id);


    void borrowBook(BorrowRecording borrowRecording);

    void bookLessOne(Integer book_id);
}
