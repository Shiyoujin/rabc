package com.example.rabc.service;

import com.example.rabc.mapper.FindRoleSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Service
public class FindRoleSetService {

    @Autowired
    private FindRoleSetMapper findRoleSetMapper;

    public Set<String> FindRoleSet(String u_id){
        return findRoleSetMapper.FindRoleSet(u_id);
    }





}
