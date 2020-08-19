package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Links;

public interface LinksService {

    String deleteByPrimaryKey(Integer linksId);

    String insert(Links record);

    String selectByPrimaryKey(Integer linksId);

    String selectLinksByPage(Integer pageNum);

    String selectAll();

    String updateByPrimaryKey(Links record);

    String selectDimByAll(String dimStr);

}
