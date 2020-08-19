package com.lemon.michstabe.service.impl;

import com.lemon.michstabe.dao.TagRelationArticleMapper;
import com.lemon.michstabe.entity.Tag;
import com.lemon.michstabe.entity.TagRelationArticle;
import com.lemon.michstabe.service.TagRelationArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagRelationArticleServiceImp implements TagRelationArticleService {

    private final TagRelationArticleMapper tagRelationArticleMapper;

    public TagRelationArticleServiceImp(TagRelationArticleMapper tagRelationArticleMapper) {
        this.tagRelationArticleMapper = tagRelationArticleMapper;
    }

    @Override
    public boolean deleteByArticleId(String articleId) {
        return tagRelationArticleMapper.deleteByArticleId(articleId) == 0 ? false : true;
    }

    @Override
    public boolean deleteByIds(String ids) {
        return tagRelationArticleMapper.deleteByIds(ids) == 0 ? false : true;
    }

    @Override
    public boolean inserts(String articleId, List<Tag> tags) {
        return tagRelationArticleMapper.inserts(articleId, tags) == 0 ? false : true;
    }

    @Override
    public boolean checkTagRelationArticleExist(String articleId, Integer tagId) {
        return tagRelationArticleMapper.checkTagRelationArticleExist(articleId, tagId) == null ? false : true;
    }

    @Override
    public List<TagRelationArticle> selectByArticleId(String articleId) {
        return tagRelationArticleMapper.selectByArticleId(articleId);
    }
}
