package com.example.service.impl;

import com.example.entity.Book;
import com.example.entity.BookCategory;
import com.example.entity.BorrowRecording;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import com.example.service.BookService;
import com.example.utils.BorrowReturnUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    /**
     * 注入bookMapper
     */
    @Resource
    private BookMapper bookMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Book> findAllBook() {
        return bookMapper.findAllBook();
    }

    @Override
    public List<BookCategory> findBookCategory() {
        return bookMapper.findBookCategory();
    }

    @Override
    public List<Book> findCategoryByBooksResult(Integer bookCategory) {
        return bookMapper.findCategoryByBooksResult(bookCategory);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void addBookCategory(BookCategory bookCategory) {
        bookMapper.addBookCategory(bookCategory);
    }

    @Override
    public void deleteBookCategory(Integer bookCategoryId) {
        bookMapper.deleteBookCategory(bookCategoryId);
    }

    @Override
    public void borrowBook(Integer bookId) {
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        Integer userId = userMapper.findUsernameByUserId(username);
        Date date = new Date();
        String borrowDate = BorrowReturnUtils.ReturnBookDate(date, 2);
        BorrowRecording borrowRecording = new BorrowRecording();
        borrowRecording.setBook_id(bookId);
        borrowRecording.setUser_id(userId);
        borrowRecording.setDate(date);
        borrowRecording.setReturnDateStr(borrowDate);
        bookMapper.borrowBook(borrowRecording);
        bookMapper.bookLessOne(bookId);
    }
}
