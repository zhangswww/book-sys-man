package com.example.mapper;

import com.example.entity.Role;

import java.util.List;

public interface RoleMapper {


    Role findRoleByUserId(Integer id);

    List<Role> findAllRole();
}
