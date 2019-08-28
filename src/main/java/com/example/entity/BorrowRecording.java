package com.example.entity;

import com.example.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

//借书记录表
public class BorrowRecording implements Serializable {
    private Integer id;
    private Integer user_id;
    private String username;
    private Integer book_id;
    private String bookname;
/*    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")*/
    private Date date;
    private String dateStr;
    private String returnDateStr;

    public String getReturnDateStr() {
        return returnDateStr;
    }

    public void setReturnDateStr(String returnDateStr) {
        this.returnDateStr = returnDateStr;
    }

    public String getDateStr() {
        if (date != null) {
            dateStr = DateUtils.date2String(date, "yyyy-MM-dd HH:mm");
        }
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Date getDate() {
        /*if (date != null) {
            return DateUtils.date2String(date, "");
        }*/
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BorrowRecording{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", username='" + username + '\'' +
                ", book_id=" + book_id +
                ", bookname='" + bookname + '\'' +
                ", date=" + date +
                ", dateStr='" + dateStr + '\'' +
                ", returnDateStr='" + returnDateStr + '\'' +
                '}';
    }
}
