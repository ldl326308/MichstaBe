package com.lemon.michstabe.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.lemon.michstabe.dao.TagMapper;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.Tag;
import com.lemon.michstabe.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TagServiceImp implements TagService {

    private final TagMapper tagMapper;

    public TagServiceImp(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Override
    public String deleteByPrimaryKey(Integer tagId) {
        int count = tagMapper.deleteByPrimaryKey(tagId);
        if (count == 0) {
            return Result.error("删除记录失败！");
        }
        return Result.success("删除记录成功！");
    }

    @Override
    public String insert(Tag record) {
        int count = tagMapper.insert(record);
        if (count == 0) {
            return Result.error("新增记录失败！");
        }
        return Result.success("新增记录成功！");
    }

    @Override
    public String selectByPrimaryKey(Integer tagId) {
        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        if (tag != null) {
            return Result.success(tag);
        }
        return Result.success("未查询到此记录！");
    }

    @Override
    public String selectTagByPageNum(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Tag> tags = tagMapper.selectAll();
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        return Result.success(pageInfo);
    }

    @Override
    public String selectAll() {
        return Result.success(tagMapper.selectAll());
    }

    @Override
    public String updateByPrimaryKey(Tag record) {
        int count = tagMapper.updateByPrimaryKey(record);
        if (count == 0) {
            return Result.error("修改记录失败！");
        }
        return Result.success("修改成功！");
    }

    @Override
    public String selectDimByAll(String dimStr) {
        List<Tag> tags = tagMapper.selectDimByAll(dimStr);
        return Result.success(tags);
    }
}
