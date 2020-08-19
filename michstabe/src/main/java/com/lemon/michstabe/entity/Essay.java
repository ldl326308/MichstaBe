package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Essay implements Serializable {
    private Integer essayId;

    private String essayContent;

    private String essayRootIn;

    private Integer essayState;

    // 前台不显示 0,1 用于前台显示 “冻结”，“正常”
    private String essayStateAlias;

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getEssayContent() {
        return essayContent;
    }

    public void setEssayContent(String essayContent) {
        this.essayContent = essayContent == null ? null : essayContent.trim();
    }

    public String getEssayRootIn() {
        return essayRootIn;
    }

    public void setEssayRootIn(String essayRootIn) {
        this.essayRootIn = essayRootIn == null ? null : essayRootIn.trim();
    }

    public Integer getEssayState() {
        return essayState;
    }

    public void setEssayState(Integer essayState) {
        this.essayState = essayState;
    }

    public String getEssayStateAlias() {
        return essayStateAlias;
    }

    public void setEssayStateAlias(String essayStateAlias) {
        this.essayStateAlias = essayStateAlias;
    }
}