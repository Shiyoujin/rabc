package com.example.rabc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public class CheckLoginMapper {

//      @Select("SELECT * FROM user WHERE u_name = #{u_name} AND pwd = #{pwd}")
//      boolean checkUser(@Param("u_name") String u_name,@Param("pwd") String pwd);

    public boolean checkUser(String u_name,String pwd){
        String sql = "SELECT * FROM user WHERE u_name = ? AND pwd = ?";
        Connection connection = JDBC.getConnection();
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,u_name);
            pstmt.setString(2,pwd);
            res = pstmt.executeQuery();
            if (res.next()){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            new JDBC().close(res,pstmt,connection);
        }
        return false;
    }
}
