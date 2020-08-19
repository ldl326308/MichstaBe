package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(String articleId);

    int insert(Article record);

    Article selectByPrimaryKey(String articleId);

    // 查询所有字段信息，用于后台管理使用
    List<Article> selectAll();

    // 查询 title、basic、createDate等信息，用于客户端展示
    List<Article> selectArticleByPageToBasic();

    int updateByPrimaryKey(Article record);

    // 根据别名判断是否存在记录
    Article selectByArticleAlias(String articleAlias);

    // 模糊查询
    List<Article> selectDimByAll(String dimStr);

    List<Article> getCurrentAdjacentArticleByArticleAlias();
}