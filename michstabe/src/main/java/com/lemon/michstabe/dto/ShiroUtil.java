package com.lemon.michstabe.dto;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    /**
     * 获取当前登入的 User
     * @return
     */
    public static String getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        return (String) subject.getSession().getAttribute("currentUser");
    }

}
