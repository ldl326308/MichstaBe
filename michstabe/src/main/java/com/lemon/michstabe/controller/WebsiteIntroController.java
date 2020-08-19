package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.WebsiteIntro;
import com.lemon.michstabe.service.WebsiteIntroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/website", produces = "application/json;charset=utf-8")
public class WebsiteIntroController {

    private final WebsiteIntroService websiteIntroService;

    public WebsiteIntroController(WebsiteIntroService websiteIntroService) {
        this.websiteIntroService = websiteIntroService;
    }

    /**
     * 获取站点信息
     * @return
     */
    @GetMapping
    public String selectWebsiteInto(){
        return websiteIntroService.selectWebsiteInto();
    }

    /**
     * 修改记录
     * @param record
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody WebsiteIntro record){
        return websiteIntroService.updateByPrimaryKey(record);
    }


}
