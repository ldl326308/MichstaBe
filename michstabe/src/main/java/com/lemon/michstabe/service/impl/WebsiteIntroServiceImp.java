package com.lemon.michstabe.service.impl;

import com.lemon.michstabe.dao.WebsiteIntroMapper;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.WebsiteIntro;
import com.lemon.michstabe.service.WebsiteIntroService;
import org.springframework.stereotype.Service;


@Service
public class WebsiteIntroServiceImp implements WebsiteIntroService {

    private final WebsiteIntroMapper websiteIntroMapper;

    public WebsiteIntroServiceImp(WebsiteIntroMapper websiteIntroMapper) {
        this.websiteIntroMapper = websiteIntroMapper;
    }

    @Override
    public String selectWebsiteInto() {
        return Result.success(websiteIntroMapper.selectWebsiteInto());
    }

    @Override
    public String updateByPrimaryKey(WebsiteIntro record) {
        int count = websiteIntroMapper.updateByPrimaryKey(record);
        if (count==0) {
            return Result.error("修改记录失败！");
        }
        return Result.success("修改记录成功！");
    }


}
