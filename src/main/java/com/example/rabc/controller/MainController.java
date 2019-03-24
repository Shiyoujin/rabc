package com.example.rabc.controller;


import com.example.rabc.mapper.CheckLoginMapper;
import com.example.rabc.mapper.JDBC;
import com.example.rabc.mapper.SetRoleMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController //组合注解
public class MainController {

    //role 1 ---top
    @GetMapping("/setRole")
    public String setRole(String u_id,String role) {

        //设置角色前，先检验 role表里面 是否存在
        //若不存在 才进行 role 表的插入
        SetRoleMapper setRoleDao = new SetRoleMapper();
        String result = setRoleDao.setRole(u_id,role);
        return result;
    }

    //role 1,2,3
    @GetMapping("/post")
    public String speak(String content){
        return "登录后才speal，此内容为："+content;
    }

    //role 1,2
    @GetMapping("/coding")
    public String coding(){
        return "programmer和god才可以coding";
    }

    @GetMapping("/login")
    public String Login(String name, String password, HttpSession session){
        if (new CheckLoginMapper().checkUser(name,password)){
            String u_id = new JDBC().findU_id(name);
            session.setAttribute("u_id",u_id);
            session.setAttribute("flag","login");
        }else {
            return "用户或密码错误";
        }
        return "登录错误";
    }
}
