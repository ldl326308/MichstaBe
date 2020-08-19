package com.lemon.michstabe.service;


import com.lemon.michstabe.entity.User;

public interface UserService {

    String selectByUserAccount(String userAccount);

    String selectByPrimaryKey(Long userId);

    String updateByPrimaryKey(User record);

    String login(User record);

    String selectByUser();
}
