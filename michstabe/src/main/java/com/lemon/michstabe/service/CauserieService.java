package com.lemon.michstabe.service;

import com.lemon.michstabe.entity.Causerie;

public interface CauserieService {

    String deleteByPrimaryKey(Integer causerieId);

    String insert(Causerie record);

    String selectByPrimaryKey(Integer causerieId);

    String selectAll(Integer pageNum);

    String updateByPrimaryKey(Causerie record);


    String selectByCauserieAlias(String causerieAlias);

    String selectDimByAll(String dimStr);

    String getCurrentAdjacentArticleByArticleAlias(String causerieAlias);

    String selectByLatestRelease();

}
