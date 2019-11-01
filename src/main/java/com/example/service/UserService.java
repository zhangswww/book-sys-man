package com.example.service;

import com.example.entity.BorrowRecording;
import com.example.entity.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    UserInfo findByUsername(String username);

    void InsertUser(UserInfo userInfo);

    List<UserInfo> finAllUser();

    void deleteUser(Integer id);

    List<BorrowRecording> findBorrowRecording();

    List<BorrowRecording> findCurRecording();

    void returnBook(Integer borrowId);

    UserInfo getCurrentUser();

}
