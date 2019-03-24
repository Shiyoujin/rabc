package com.example.rabc.service;

import com.example.rabc.mapper.SetRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class SetRoleService {

    @Autowired
    SetRoleMapper setRoleMapper;

    public String SetRole(String u_id,String role){
        return setRoleMapper.setRole(u_id,role);
    }
}
