package com.example.mapper;

import com.example.entity.BorrowRecording;
import com.example.entity.UserInfo;
import com.example.entity.User_Role;

import java.util.List;

public interface UserMapper {

    UserInfo findByUsername(String username);

    Integer InsertUser(UserInfo userInfo);

    void InsertUserRole(User_Role user_role);

    List<UserInfo> finAllUser();

    void deleteUser(Integer id);

    List<BorrowRecording> findBorrowRecording();

    /**
     * 根据用户id查询用户姓名
     * @return
     */
    String findUserIdByUsername(Integer user_id);

    Integer findUsernameByUserId(String username);
}
