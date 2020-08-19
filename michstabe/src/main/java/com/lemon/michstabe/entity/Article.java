package com.lemon.michstabe.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class Article implements Serializable {
    private String articleId;

    private String articleAlias;

    private String articleTitle;

    private String articleImg;

    private String articleBasic;

    private String articleCreateDate;

    private String articleLastUpdateDate;

    private String articleProtect;

    // 前台不显示密码，只显示”加密“、”未加密“
    private String articleProtectAlias;

    private Integer articleStick;

    private Integer articleState;

    // 前台不显示 0,1 用于前台显示 “冻结”，“正常”
    private String articleStateAlias;

    private Integer articleLikeCount;

    private Integer articleSickOfCount;

    private String articleHtmlContent;

    private String articleMarkdownContent;


    // 与标签是一对多的关系
    private List<Tag> tags;

    public String getArticleProtectAlias() {
        return articleProtectAlias;
    }

    public void setArticleProtectAlias(String articleProtectAlias) {
        this.articleProtectAlias = articleProtectAlias;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleAlias() {
        return articleAlias;
    }

    public void setArticleAlias(String articleAlias) {
        this.articleAlias = articleAlias == null ? null : articleAlias.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg == null ? null : articleImg.trim();
    }

    public String getArticleBasic() {
        return articleBasic;
    }

    public void setArticleBasic(String articleBasic) {
        this.articleBasic = articleBasic == null ? null : articleBasic.trim();
    }

    public String getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(String articleCreateDate) {
        this.articleCreateDate = articleCreateDate == null ? null : articleCreateDate.trim();
    }

    public String getArticleProtect() {
        return articleProtect;
    }

    public void setArticleProtect(String articleProtect) {
        this.articleProtect = articleProtect == null ? null : articleProtect.trim();
    }

    public Integer getArticleStick() {
        return articleStick;
    }

    public void setArticleStick(Integer articleStick) {
        this.articleStick = articleStick;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public Integer getArticleSickOfCount() {
        return articleSickOfCount;
    }

    public void setArticleSickOfCount(Integer articleSickOfCount) {
        this.articleSickOfCount = articleSickOfCount;
    }

    public String getArticleHtmlContent() {
        return articleHtmlContent;
    }

    public void setArticleHtmlContent(String articleHtmlContent) {
        this.articleHtmlContent = articleHtmlContent;
    }

    public String getArticleMarkdownContent() {
        return articleMarkdownContent;
    }

    public void setArticleMarkdownContent(String articleMarkdownContent) {
        this.articleMarkdownContent = articleMarkdownContent;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getArticleLastUpdateDate() {
        return articleLastUpdateDate;
    }

    public void setArticleLastUpdateDate(String articleLastUpdateDate) {
        this.articleLastUpdateDate = articleLastUpdateDate;
    }

    public String getArticleStateAlias() {
        return articleStateAlias;
    }

    public void setArticleStateAlias(String articleStateAlias) {
        this.articleStateAlias = articleStateAlias;
    }
}