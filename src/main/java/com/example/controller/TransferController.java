package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transfer")
public class TransferController {

    private Logger logger = Logger.getLogger(TransferController.class);

    @GetMapping("/addUserPage")
    public String transferUserPage() {
        return "admins/addUser";
    }

    @GetMapping("/addBook")
    public String transferAddBookPage() {
        return "admins/addBook";
    }

    @GetMapping("/findCategoryPage")
    public String findCategoryPage() {
        logger.info("TransferController的findCategoryPage方法");
        return "admins/addBookCategory";
    }

    @GetMapping("/borrowRecordReturn")
    public String t1() {
        return "users/borrowRecordReturn";
    }

/*    @GetMapping("/findBooksBorrow")
    public String t2() {
        return "redirect:book/bookAll";
    }*/

    @GetMapping("/userMessage")
    public String t3() {
        return "users/userMessage";
    }


}
