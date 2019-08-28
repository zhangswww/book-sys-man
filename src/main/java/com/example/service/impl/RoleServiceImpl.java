package com.example.service.impl;

import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import com.example.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }
}
