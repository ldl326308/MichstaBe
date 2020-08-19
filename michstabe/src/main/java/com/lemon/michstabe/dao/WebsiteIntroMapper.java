package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.WebsiteIntro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteIntroMapper {

    WebsiteIntro selectWebsiteInto();

    int updateByPrimaryKey(WebsiteIntro record);
}