package com.example.rabc.service;

import com.example.rabc.mapper.CheckRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckRoleService {

    @Autowired
    CheckRoleMapper checkRoleMapper;

    public boolean checkRole(String u_id,String role){
        return checkRoleMapper.checkRole(u_id,role);
    }
}
