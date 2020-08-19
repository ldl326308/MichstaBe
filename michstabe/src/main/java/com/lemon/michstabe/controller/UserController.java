package com.lemon.michstabe.controller;

import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.User;
import com.lemon.michstabe.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user", produces = "application/json;charset=utf-8")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用于登录验证
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 用于获取用户是否登录
     *
     * @return
     */
    @GetMapping(path = "/isLogin")
    public String isLogin() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return Result.success("用户已登录！");
        }
        return Result.error("请先登录！");
    }

    /**
     * 用于注销已登录的用户
     *
     * @return
     */
    @GetMapping(path = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.success("注销成功！");
    }

    /**
     * 查询 User 记录
     * @return
     */
    @GetMapping(path = "/current")
    public String selectByUser(){
        return userService.selectByUser();
    }

    /**
     * 修改 user 信息
     * @param record
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody User record){
        return userService.updateByPrimaryKey(record);
    }

}
