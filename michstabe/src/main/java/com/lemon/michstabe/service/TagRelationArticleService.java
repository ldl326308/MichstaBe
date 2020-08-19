package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Tag;
import com.lemon.michstabe.entity.TagRelationArticle;

import java.util.List;


public interface TagRelationArticleService {
    // 根据articleId删除多条记录
    boolean deleteByArticleId(String articleId);

    // 根据 Id 批量删除
    boolean deleteByIds(String ids);

    // 插入多条tagRelationArticle记录
    boolean inserts(String articleId,List<Tag> tags);


    boolean checkTagRelationArticleExist(String articleId, Integer tagId);

    // 根据articleId查询相关记录
    List<TagRelationArticle> selectByArticleId(String articleId);
}
