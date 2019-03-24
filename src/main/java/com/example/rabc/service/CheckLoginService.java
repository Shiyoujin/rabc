package com.example.rabc.service;

import com.example.rabc.mapper.CheckLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckLoginService {

    @Autowired
    private CheckLoginMapper checkLoginMapper;

    public boolean checkUser(String u_name,String pwd){
        return checkLoginMapper.checkUser(u_name,pwd);
    }
}
