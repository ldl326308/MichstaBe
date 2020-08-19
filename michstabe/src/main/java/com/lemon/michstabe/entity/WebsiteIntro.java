package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WebsiteIntro implements Serializable {
    private Integer websiteIntroId;

    private String websiteIntroLogo;

    private String websiteIntroMainBg;

    private String websiteIntroBlogBg;

    private String websiteIntroForeword;

    private String websiteIntroMarkdownDescribe;

    private String websiteIntroHtmlDescribe;

    public Integer getWebsiteIntroId() {
        return websiteIntroId;
    }

    public void setWebsiteIntroId(Integer websiteIntroId) {
        this.websiteIntroId = websiteIntroId;
    }

    public String getWebsiteIntroLogo() {
        return websiteIntroLogo;
    }

    public void setWebsiteIntroLogo(String websiteIntroLogo) {
        this.websiteIntroLogo = websiteIntroLogo;
    }

    public String getWebsiteIntroMainBg() {
        return websiteIntroMainBg;
    }

    public void setWebsiteIntroMainBg(String websiteIntroMainBg) {
        this.websiteIntroMainBg = websiteIntroMainBg;
    }

    public String getWebsiteIntroBlogBg() {
        return websiteIntroBlogBg;
    }

    public void setWebsiteIntroBlogBg(String websiteIntroBlogBg) {
        this.websiteIntroBlogBg = websiteIntroBlogBg;
    }

    public String getWebsiteIntroForeword() {
        return websiteIntroForeword;
    }

    public void setWebsiteIntroForeword(String websiteIntroForeword) {
        this.websiteIntroForeword = websiteIntroForeword;
    }

    public String getWebsiteIntroMarkdownDescribe() {
        return websiteIntroMarkdownDescribe;
    }

    public void setWebsiteIntroMarkdownDescribe(String websiteIntroMarkdownDescribe) {
        this.websiteIntroMarkdownDescribe = websiteIntroMarkdownDescribe;
    }

    public String getWebsiteIntroHtmlDescribe() {
        return websiteIntroHtmlDescribe;
    }

    public void setWebsiteIntroHtmlDescribe(String websiteIntroHtmlDescribe) {
        this.websiteIntroHtmlDescribe = websiteIntroHtmlDescribe;
    }
}