package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Tag implements Serializable {
    private Integer tagId;

    private String tagName;

    private String tagDescribe;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagDescribe() {
        return tagDescribe;
    }

    public void setTagDescribe(String tagDescribe) {
        this.tagDescribe = tagDescribe == null ? null : tagDescribe.trim();
    }
}