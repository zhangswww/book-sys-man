package com.example.service.impl;

import com.example.entity.BorrowRecording;
import com.example.entity.Role;
import com.example.entity.UserInfo;
import com.example.entity.User_Role;
import com.example.mapper.BookMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.example.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private BookMapper bookMapper;

    @Override
    public UserInfo findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void InsertUser(UserInfo userInfo) {
        //为用户密码加密
        String password = MD5Utils.encode(userInfo.getPassword());
        //重新放入用户对象
        userInfo.setPassword(password);
        System.out.println(userInfo);
        //插入userInfo对象
        userMapper.InsertUser(userInfo);
        //获取自动生成的用户id和将接收到的角色id转为integer类型
        String roleId = userInfo.getRole();
        Integer userId = userInfo.getId();
        User_Role user_role = new User_Role();
        user_role.setRoleId(Integer.parseInt(roleId));
        user_role.setUserId(userId);
        //将用户id用户角色对象插入数据库
        userMapper.InsertUserRole(user_role);
    }

    @Override
    public List<UserInfo> finAllUser() {
        return userMapper.finAllUser();
    }

    @Override
    public void deleteUser(Integer id) {
        logger.info("走了删除user的service");
        userMapper.deleteUser(id);
    }

    @Override
    public List<BorrowRecording> findBorrowRecording() {
        return userMapper.findBorrowRecording();
    }

    @Override
    public List<BorrowRecording> findCurRecording() {
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        Integer userId = userMapper.findUsernameByUserId(username);
        return userMapper.findCurRecording(userId);
    }

    @Override
    public void returnBook(Integer borrowId) {
        /*SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        Integer userId = userMapper.findUsernameByUserId(username);//获取当前用户id
        */

        //先通过借书id查询出图书id
        Integer bookId = bookMapper.findBoIdByBookId(borrowId);
        //被借图书的数量加1
        logger.info("findBoIdByBookId---------------bookId=" + bookId);
        /**
         * 为什么图书数量没有加1
         */
        bookMapper.addOneBook(bookId);
        logger.info("addOneBook================bookId=" + bookId);

        //在借书记录表中删除那个借书记录（通过借书id）
        userMapper.deleteBorrowRecord(borrowId);
        logger.info("deleteBorrowRecord----------------borrowId=" + borrowId);
    }

    @Override
    public UserInfo getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        UserInfo userInfo = userMapper.findByUsername(username);
        return userInfo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userMapper.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("根据用户名查询出来的用户信息：" + userInfo);
//        System.out.println(userInfo);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority(role.getName()));
        }
        return list;
    }
}
