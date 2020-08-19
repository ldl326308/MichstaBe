package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Essay;

import java.util.List;


public interface EssayService {

    String deleteByPrimaryKey(Integer essayId);

    String insert(Essay record);

    String selectByPrimaryKey(Integer essayId);

    String selectAll(Integer page);

    String updateByPrimaryKey(Essay record);


    String selectDimByAll(String dimStr);

}
