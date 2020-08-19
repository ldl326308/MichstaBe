package com.lemon.michstabe.config.bean;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegisterConfig {

    // Gson对象放入Spring中管理（Gson是用于格式化JSON的轻量工具）
    @Bean(name = "gson")
    public Gson getGson() {
        return new Gson();
    }


}
