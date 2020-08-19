package com.lemon.michstabe.dao;

import com.lemon.michstabe.entity.Article;
import com.lemon.michstabe.entity.Causerie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CauserieMapper {
    int deleteByPrimaryKey(Integer causerieId);

    int insert(Causerie record);

    Causerie selectByPrimaryKey(Integer causerieId);

    List<Causerie> selectAll();

    int updateByPrimaryKey(Causerie record);

    // 根据 causerieAlias 查询记录
    Causerie selectByCauserieAlias(String causerieAlias);

    // 模糊查询
    List<Causerie> selectDimByAll(String dimStr);

    List<Causerie> getCurrentAdjacentArticleByArticleAlias();

    // 查询最新的提一条记录
    Causerie selectByLatestRelease();
}