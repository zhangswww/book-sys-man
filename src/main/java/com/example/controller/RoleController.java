package com.example.controller;

import com.example.entity.Role;
import com.example.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private static Logger logger = Logger.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    @ResponseBody
    public List<Role> findAllRole() {
        logger.info("走了RoleController的 findAllRole方法");
        List<Role> roleList = roleService.findAllRole();
        for (Role role : roleList) {
            System.out.println(role);
        }
        return roleList;
    }
}
