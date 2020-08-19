package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectByUserAccount(String userAccount);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKey(User record);

    User login(String userAccount);

    User selectByUser();
}