package com.lemon.michstabe.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.michstabe.dao.EssayMapper;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.Essay;
import com.lemon.michstabe.service.EssayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImp implements EssayService {

    private final EssayMapper essayMapper;

    public EssayServiceImp(EssayMapper essayMapper) {
        this.essayMapper = essayMapper;
    }

    @Override
    public String deleteByPrimaryKey(Integer essayId) {
        int count = essayMapper.deleteByPrimaryKey(essayId);
        if (count == 0) {
            return Result.error("删除记录失败！");
        }
        return Result.success("删除记录成功！");
    }

    @Override
    public String insert(Essay record) {
        if (record.getEssayContent().isEmpty() | record.getEssayContent() == null) {
            return Result.error("内容不能为空！");
        }
        if (record.getEssayRootIn().isEmpty() | record.getEssayRootIn() == null) {
            record.setEssayRootIn("无名");
        }
        if (record.getEssayState() == null | (record.getEssayState() != 0 & record.getEssayState() != 1)) {
            record.setEssayState(0);
        }
        int essayId = essayMapper.insert(record);
        if (essayId == 0) {
            return Result.error("新增记录失败！");
        }
        Essay essay = essayMapper.selectByPrimaryKey(essayId);

        return Result.success(essay);
    }

    @Override
    public String selectByPrimaryKey(Integer essayId) {
        Essay essay = essayMapper.selectByPrimaryKey(essayId);
        if (essay == null) {
            return Result.success("未查询到记录！");
        }
        return Result.success(essay);
    }

    @Override
    public String selectAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Essay> essays = essayMapper.selectAll();
        PageInfo<Essay> pageInfo = new PageInfo<Essay>(essays);
        return Result.success(pageInfo);
    }

    @Override
    public String updateByPrimaryKey(Essay record) {
        int count = essayMapper.updateByPrimaryKey(record);
        if (count == 0) {
            return Result.error("修改记录失败！");
        }
        Essay essay = essayMapper.selectByPrimaryKey(record.getEssayId());
        return Result.success(essay);
    }

    @Override
    public String selectDimByAll(String dimStr) {
        List<Essay> essays = essayMapper.selectDimByAll(dimStr);
        return Result.success(essays);
    }
}
