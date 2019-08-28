package com.example.controller;

import com.example.entity.BorrowRecording;
import com.example.entity.UserInfo;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 来到登录页面
     */
  /*  @GetMapping("/")
    public String login() {
        return "userlogin";
    }*/

    /**
     * 来到主页面
     * @return
     */
    @PostMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/index1")
    public String index1() {
        return "index";
    }

    /**
     * 登录失败页面
     * @return
     */
  /*  @GetMapping("/login?error")
    public String loginError() {
        return "loginError";
    }*/

    /**
     * 登陆页
     * @return
     */
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("走controller了");
        return "login";
    }

    /**
     * get获取，post创建,put修改，delete删除
     * 添加用户
     */
    @PostMapping("/user")
    public String addUser(UserInfo userInfo) {
        System.out.println(userInfo);
        userService.InsertUser(userInfo);
        return "redirect:transfer/addUserPage";
    }

    /**
     * 获取所有用户信息
     * @return
     */
    @GetMapping("/user")
    public String findAllUser(Model model) {
        List<UserInfo> userList = userService.finAllUser();
        model.addAttribute("userList", userList);
        return "admins/showUsers";
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Integer id) {
        logger.info("走了删除user的controller");
        userService.deleteUser(id);
    }

    /**
     * 借书记录
     * @return
     */
    @GetMapping("/borrowing")
    public String findBorrowRecording(Model model) {
        List<BorrowRecording> recordingList = userService.findBorrowRecording();
        model.addAttribute("recordingList", recordingList);
        return "admins/allBorrowingBooksRecord";
    }

}
