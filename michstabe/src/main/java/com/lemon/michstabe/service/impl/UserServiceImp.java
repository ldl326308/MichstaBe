package com.lemon.michstabe.service.impl;

import com.lemon.michstabe.dao.UserMapper;
import com.lemon.michstabe.dto.MD5Util;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.User;
import com.lemon.michstabe.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserMapper userMapper;

    public UserServiceImp(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String updateByPrimaryKey(User record) {
        // 如果要修改密码，对前端传入的密码进行加密操作
        if (record.getUserPassword().trim() != "") {
            record.setUserPassword(MD5Util.toMd5(record.getUserPassword()));
        }

        int count = userMapper.updateByPrimaryKey(record);
        if (count == 0) {
            return Result.error("修改记录失败！");
        }
        return Result.success("修改记录成功！");
    }

    @Override
    public String selectByUser() {
        return Result.success(userMapper.selectByUser());
    }

    @Override
    public String login(User user) {
        // 创建token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserAccount(), MD5Util.toMd5(user.getUserPassword()));
        Subject subject = SecurityUtils.getSubject();
        try {
            // 登录
            subject.login(token);
            // 登录成功将用户信息保存到Session
            User currentUser = userMapper.selectByUserAccount(user.getUserAccount());
            subject.getSession().setAttribute("currentUser", currentUser);
        } catch (UnknownAccountException e) {
            return Result.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.error(e.getMessage());
        } catch (LockedAccountException e) {
            return Result.error(e.getMessage());
        }
        // 登录成功，前端进行页面跳转
        return Result.success("登录成功！");
    }

    @Override
    public String selectByUserAccount(String userAccount) {
        User user = userMapper.selectByUserAccount(userAccount);
        if (user == null) {
            return Result.error("未查询到此记录！");
        }
        return Result.success(user);
    }

    @Override
    public String selectByPrimaryKey(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return Result.error("未查询到记录！");
        }
        return Result.success(user);
    }
}
