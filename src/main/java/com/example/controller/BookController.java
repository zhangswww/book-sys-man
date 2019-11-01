package com.example.controller;

import com.example.entity.Book;
import com.example.entity.BookCategory;
import com.example.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String findAllBook(@RequestParam(name = "page", required = true, defaultValue = "1")Integer page,
                              @RequestParam(name = "size", required = true, defaultValue = "4")Integer size,
                              Model model) {
        PageHelper.startPage(page, size);
        List<Book> bookList = bookService.findAllBook();
        PageInfo pageInfo = new PageInfo(bookList);
        model.addAttribute("pageInfo", pageInfo);
        return "admins/showBooks";
    }

    @GetMapping("/findBooksBorrow")
    public String findBooks(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "users/findBooksBorrow";
    }

    @GetMapping("/bookCategory")
    @ResponseBody
    public List<BookCategory> bookCategory() {
        return bookService.findBookCategory();
    }

    /**
     * 根据图书的类别查询图书
     * @return
     */
    @GetMapping("/showCategoryBooks")
    public String showCategoryBooks(Integer bookCategory, Model model) {
        List<Book> bookList = bookService.findCategoryByBooksResult(bookCategory);
        model.addAttribute("bookList", bookList);
        return "admins/showBooks";
    }

    @GetMapping("/showCategoryBooksToUser")
    public String showCategoryBooksToUser(Integer bookCategory, Model model) {
        List<Book> bookList = bookService.findCategoryByBooksResult(bookCategory);
        model.addAttribute("bookList", bookList);
        return "users/findBooksBorrow";
    }

    @PostMapping("/addBook")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "admins/addBook";
    }

    /**
     * 新建图书类别
     * @return
     */
    @PostMapping("/Category")
    public String addBookCategory(BookCategory bookCategory) {
        logger.info("调用service之前");
        bookService.addBookCategory(bookCategory);
        logger.info("调用service之后");
        return "admins/addBookCategory";
    }

    /**
     * 删除图书类别
     * @return
     */
    @PostMapping("/deleteCategory")
    public String deleteBookCategory(@RequestParam("bookCategoryId") Integer bookCategoryId) {
        bookService.deleteBookCategory(bookCategoryId);
        return "admins/addBookCategory";
    }

    /**
     * 借书
     * @param bookId
     * @return
     */
    @PostMapping("/borrowBook")
    public String borrowBook(@RequestParam("bookId") Integer bookId) {
        bookService.borrowBook(bookId);
        return "redirect:findBooksBorrow";
    }

    @PostMapping("/books")
    public String addBook(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "admins/showBooks";
    }

/*    @PutMapping("/books/{book_id}")
    public String updateBook(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "admins/showBooks";
    }

    @DeleteMapping("/books/{book_id}")
    public String deleteBook(Model model) {
        List<Book> bookList = bookService.findAllBook();
        model.addAttribute("bookList", bookList);
        return "admins/showBooks";
    }*/
}
