package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.Essay;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EssayMapper {
    int deleteByPrimaryKey(Integer essayId);

    int insert(Essay record);

    Essay selectByPrimaryKey(Integer essayId);

    List<Essay> selectAll();

    int updateByPrimaryKey(Essay record);

    List<Essay> selectDimByAll(String dimStr);
}