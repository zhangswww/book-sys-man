package com.example.entity;

import java.io.Serializable;

public class User_Role implements Serializable {
    private Integer user_id;
    private Integer role_id;

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public Integer getRoleId() {
        return role_id;
    }

    public void setRoleId(Integer roleId) {
        this.role_id = roleId;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "userId=" + user_id +
                ", roleId=" + role_id +
                '}';
    }
}
