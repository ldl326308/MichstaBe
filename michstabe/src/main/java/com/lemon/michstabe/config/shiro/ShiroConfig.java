package com.lemon.michstabe.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig  {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        shiroFilterFactoryBean.setUnauthorizedUrl("/404");
//        shiroFilterFactoryBean.setLoginUrl("/login");
//
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/manager/addBlog", "authc");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/manager/websiteIntro", "authc");
//        filterChainDefinitionMap.put("/manager/blog", "authc");

//        filterChainDefinitionMap.put("/**","anon");
//        filterChainDefinitionMap.put("/bootstrap/**","anon");
//        filterChainDefinitionMap.put("/images/**","anon");
//        filterChainDefinitionMap.put("/ueditor/**","anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm(){
        return new ShiroRealm();
    }


}
