package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Causerie implements Serializable {
    private Integer causerieId;

    private String causerieAlias;

    private String causerieTitle;

    private String causerieBasic;

    private String causerieMarkdownContent;

    private String causerieHtmlContent;

    private String causerieCreateTime;

    private Integer causerieState;

    private String causerieStateAlias;

    public Integer getCauserieId() {
        return causerieId;
    }

    public void setCauserieId(Integer causerieId) {
        this.causerieId = causerieId;
    }

    public String getCauserieBasic() {
        return causerieBasic;
    }

    public void setCauserieBasic(String causerieBasic) {
        this.causerieBasic = causerieBasic;
    }

    public String getCauserieAlias() {
        return causerieAlias;
    }

    public void setCauserieAlias(String causerieAlias) {
        this.causerieAlias = causerieAlias;
    }

    public String getCauserieTitle() {
        return causerieTitle;
    }

    public void setCauserieTitle(String causerieTitle) {
        this.causerieTitle = causerieTitle;
    }

    public String getCauserieMarkdownContent() {
        return causerieMarkdownContent;
    }

    public void setCauserieMarkdownContent(String causerieMarkdownContent) {
        this.causerieMarkdownContent = causerieMarkdownContent;
    }

    public String getCauserieHtmlContent() {
        return causerieHtmlContent;
    }

    public void setCauserieHtmlContent(String causerieHtmlContent) {
        this.causerieHtmlContent = causerieHtmlContent;
    }

    public String getCauserieCreateTime() {
        return causerieCreateTime;
    }

    public void setCauserieCreateTime(String causerieCreateTime) {
        this.causerieCreateTime = causerieCreateTime;
    }

    public Integer getCauserieState() {
        return causerieState;
    }

    public void setCauserieState(Integer causerieState) {
        this.causerieState = causerieState;
    }

    public String getCauserieStateAlias() {
        return causerieStateAlias;
    }

    public void setCauserieStateAlias(String causerieStateAlias) {
        this.causerieStateAlias = causerieStateAlias;
    }
}