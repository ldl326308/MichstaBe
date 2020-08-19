package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Tag;

import java.util.List;

public interface TagService {

    String deleteByPrimaryKey(Integer tagId);

    String insert(Tag record);

    String selectByPrimaryKey(Integer tagId);

    String selectTagByPageNum(Integer pageNum);

    String selectAll();

    String updateByPrimaryKey(Tag record);

    String selectDimByAll(String dimStr);

}
