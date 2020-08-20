package com.lemon.michstabe.config.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
@ComponentScan("com.lemon.michstabe")
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image");
//        registry.addResourceHandler("/image/article/**").addResourceLocations("classpath:/static/image/article/");
        // 解决图片上传不能立刻访问的问题，刷新文件夹
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+ System.getProperty("user.dir")+"/src/main/resources/static/image/");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://lixsx.net")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}
