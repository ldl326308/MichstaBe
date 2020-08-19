package com.lemon.michstabe.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.lemon.michstabe.dao.LinksMapper;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.Links;
import com.lemon.michstabe.service.LinksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksServiceImp implements LinksService {

    private final LinksMapper linksMapper;

    public LinksServiceImp(LinksMapper linksMapper) {
        this.linksMapper = linksMapper;
    }

    @Override
    public String deleteByPrimaryKey(Integer linksId) {
        int count = linksMapper.deleteByPrimaryKey(linksId);
        if (count==0) {
            return Result.error("删除记录失败！");
        }
        return Result.success("删除记录成功！");
    }

    @Override
    public String insert(Links record) {
        int count = linksMapper.insert(record);
        if (count == 0) {
            return Result.error("新增记录失败！");
        }
        return Result.success("新增记录成功！");
    }

    @Override
    public String selectByPrimaryKey(Integer linksId) {
        Links links = linksMapper.selectByPrimaryKey(linksId);
        if (links==null) {
            return Result.success("未查询到记录！");
        }
        return Result.success(links);
    }

    @Override
    public String selectLinksByPage(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Links> links = linksMapper.selectAll();
        PageInfo<Links> pageInfo = new PageInfo<Links>(links);
        return Result.success(pageInfo);
    }

    @Override
    public String selectAll() {
        return Result.success(linksMapper.selectAll());
    }

    @Override
    public String updateByPrimaryKey(Links record) {
        int count = linksMapper.updateByPrimaryKey(record);
        if (count==0) {
            return Result.error("修改记录失败！");
        }
        return Result.success("修改记录成功！");
    }

    @Override
    public String selectDimByAll(String dimStr) {
        List<Links> links = linksMapper.selectDimByAll(dimStr);
        return Result.success(links);
    }
}
