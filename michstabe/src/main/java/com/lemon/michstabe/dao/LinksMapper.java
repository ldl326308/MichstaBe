package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.Links;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinksMapper {
    int deleteByPrimaryKey(Integer linksId);

    int insert(Links record);

    Links selectByPrimaryKey(Integer linksId);

    List<Links> selectAll();

    int updateByPrimaryKey(Links record);

    List<Links> selectDimByAll(String dimStr);
}