package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Article;

public interface ArticleService {

    String deleteByPrimaryKey(String articleId);

    String insert(Article record);

    // 客户端有限制访问
    String clientGetArticleByArticleAlias(String articleAlias, String articleProtect);

    // 管理员无限制访问
    String managerGetArticleByArticleAlias(String articleAlias);

    String selectAll(Integer pageNum);

    // 查询 title、basic、createDate等信息，用于客户端展示
    String selectArticleByPageToBasic(Integer pageNum);

    String updateByPrimaryKey(Article record);

    // 根据别名判断是否存在记录
    String selectByArticleAlias(String articleAlias);

    // 模糊查询
    String selectDimByAll(String dimStr);

    String getCurrentAdjacentArticleByArticleAlias(String articleAlias);
}
