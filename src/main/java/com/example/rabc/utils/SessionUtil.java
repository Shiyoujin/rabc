package com.example.rabc.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    //全局删除 id标示
    public static String GLOB_DELETE_ID_VAL = "globDeleteIdVal";

    //获取request
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    //获取session
    public static HttpSession getSession() {
        //若存在会话则返回该会话，否则返回NULL 如果 ture，否则新创建一个会话
        return getRequest().getSession(false);
    }

    //获取真实路径
    public static String gerRealRootPath() {
        //这里有用到 前面 获取 requet 的 getRequest()方法
        //getRealPath("/") = D:\apache-tomcat-6.0.13\webapps\WebDemo\
        return getRequest().getServletContext().getRealPath("/");
    }

    //获取ip
    public static String getIp(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (servletRequestAttributes != null){
            HttpServletRequest request = servletRequestAttributes.getRequest();
            //getRemoteAddr() 获取ip地址
            return request.getRemoteAddr();
        }
        return null;
    }

    //获取 session中的Attribute
    //参数 name，返回
    public static Object getSessionAttribute(String name){
        HttpServletRequest request = getRequest();
        //返回 获取session中 name的值
        return request == null ? null:request.getSession().getAttribute(name);
    }

    //设置session的Attribute
    //参数 name，value
    public static void setSessionAttribute(String name,Object value){
        HttpServletRequest request = getRequest();
        if (request!=null){
            //设置 session
            request.getSession().setAttribute(name,value);
        }
    }

    //获取上下文的 path
    public static String getContextPath(){
        //就是 项目名 /WebDemo
        return getRequest().getContextPath();
    }

    //删除 session中的 Attribute
    //参数 name
    public static void removeSessionAttribute(String name){
        getRequest().getSession().removeAttribute(name);
    }
}
