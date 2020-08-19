package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Links implements Serializable {
    private Integer linksId;

    private String linksName;

    private String linksImg;

    private String linksSite;

    private String linksDescribe;

    private Integer linksState;

    private String linksStateAlias;

    public Integer getLinksId() {
        return linksId;
    }

    public void setLinksId(Integer linksId) {
        this.linksId = linksId;
    }

    public String getLinksName() {
        return linksName;
    }

    public void setLinksName(String linksName) {
        this.linksName = linksName == null ? null : linksName.trim();
    }

    public String getLinksImg() {
        return linksImg;
    }

    public void setLinksImg(String linksImg) {
        this.linksImg = linksImg == null ? null : linksImg.trim();
    }

    public String getLinksSite() {
        return linksSite;
    }

    public void setLinksSite(String linksSite) {
        this.linksSite = linksSite == null ? null : linksSite.trim();
    }

    public String getLinksDescribe() {
        return linksDescribe;
    }

    public void setLinksDescribe(String linksDescribe) {
        this.linksDescribe = linksDescribe == null ? null : linksDescribe.trim();
    }

    public Integer getLinksState() {
        return linksState;
    }

    public void setLinksState(Integer linksState) {
        this.linksState = linksState;
    }

    public String getLinksStateAlias() {
        return linksStateAlias;
    }

    public void setLinksStateAlias(String linksStateAlias) {
        this.linksStateAlias = linksStateAlias;
    }
}