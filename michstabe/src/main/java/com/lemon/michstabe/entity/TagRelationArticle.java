package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

@Component
public class TagRelationArticle {

    private Integer tagRelationArticleId;

    private Integer tagId;

    private String articleId;

    public Integer getTagRelationArticleId() {
        return tagRelationArticleId;
    }

    public void setTagRelationArticleId(Integer tagRelationArticleId) {
        this.tagRelationArticleId = tagRelationArticleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
