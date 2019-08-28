package com.example;

import com.example.entity.*;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import com.example.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookSysManApplicationTests {

/*    @Autowired
    private UserService userService;*/

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void contextLoads() {
        Integer userId = userMapper.findUsernameByUserId("zhangsan");
        System.out.println(userId);

        /*userMapper.deleteUser(8);*/
       /* List<BorrowRecording> recordingList = userMapper.findBorrowRecording();
        for (BorrowRecording borrowRecording : recordingList) {
            System.out.println(borrowRecording);
        }*/

       /* User_Role user_role = new User_Role();
        user_role.setUserId(2);
        user_role.setRoleId(2);
        userMapper.InsertUserRole(user_role);*/
       /* List<BookCategory> categoryList = bookMapper.findBookCategory();
        for (BookCategory bookCategory : categoryList) {
            System.out.println(bookCategory);
        }*/


       /* UserInfo user = userService.findByUsername("admins");
        System.out.println(user);*/
        /*List<Role> roleList = roleService.findAllRole();
        System.out.println(roleList);*/
/*
        UserInfo userInfo = new UserInfo();
        userInfo.setPhone("11111111112");
        userInfo.setBirthday("2010-10-10");
        userInfo.setPassword("123456");
        userInfo.setEmail("234@qq.com");
        userInfo.setGender("男");
        userInfo.setUsername("zl");
        Integer id = userMapper.InsertUser(userInfo);
        Integer infoId = userInfo.getId();
        System.out.println("id为：" + id);
        System.out.println("asdujishnbb为：" + infoId);
*/

    }

}
