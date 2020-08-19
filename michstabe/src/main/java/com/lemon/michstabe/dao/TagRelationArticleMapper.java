package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.Tag;
import com.lemon.michstabe.entity.TagRelationArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRelationArticleMapper {
    // 根据articleId删除多条记录
    int deleteByArticleId(String articleId);

    // 根据 Id 批量删除
    int deleteByIds(String ids);

    // 插入多条tagRelationArticle记录
    int inserts(@Param("articleId") String articleId,@Param("tags") List<Tag> tags);

    TagRelationArticle checkTagRelationArticleExist(@Param("articleId") String articleId, @Param("tagId") Integer tagId);

    // 根据 articleId 查询所有相关记录
    List<TagRelationArticle> selectByArticleId(String articleId);

}
