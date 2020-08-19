package com.lemon.michstabe.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.michstabe.dao.CauserieMapper;
import com.lemon.michstabe.dto.DateUtil;
import com.lemon.michstabe.dto.RandomUtil;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.Causerie;
import com.lemon.michstabe.service.CauserieService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CauserieServiceImp implements CauserieService {

    private final CauserieMapper causerieMapper;

    public CauserieServiceImp(CauserieMapper causerieMapper) {
        this.causerieMapper = causerieMapper;
    }

    @Override
    public String deleteByPrimaryKey(Integer causerieId) {
        int count = causerieMapper.deleteByPrimaryKey(causerieId);
        if (count == 0) {
            return Result.error("删除记录失败！");
        }
        return Result.success("删除记录成功！");
    }

    @Override
    public String insert(Causerie record) {
        // 数据初始化
        // 生成别名
        String alias = "";
        for (int i = 0; i < 100; i++) {
            // 生成 alias
            alias = String.valueOf(RandomUtil.randomInt(100, 1000)) + ".html";
            // 判断 alias 是否已存在
            Causerie causerie = causerieMapper.selectByCauserieAlias(alias);
            if (causerie == null) {
                // 设置别名
                record.setCauserieAlias(alias);
                break;
            }
        }

        // 设置 basic
        if (record.getCauserieBasic().length() > 120) {
            record.setCauserieBasic(record.getCauserieBasic().substring(0, 120));
        }

        // 设置创建时间
        record.setCauserieCreateTime(DateUtil.getNowDatetime());

        // insert tag and article relation table
        int count = causerieMapper.insert(record);
        if (count == 0) {
            return Result.error("新增记录失败！");
        }

        return Result.success("新增记录成功！");
    }

    @Override
    public String selectByPrimaryKey(Integer causerieId) {

        return null;
    }

    @Override
    public String selectAll(Integer pageNum) {
        // 分页
        PageHelper.startPage(pageNum, 3);
        List<Causerie> causeries = causerieMapper.selectAll();
        PageInfo<Causerie> info = new PageInfo<>(causeries);
        return Result.success(info);
    }

    @Override
    public String updateByPrimaryKey(Causerie record) {
        int count = causerieMapper.updateByPrimaryKey(record);
        if (count==0) {
            return Result.error("修改记录失败！");
        }
        return Result.success("修改记录成功！");
    }

    @Override
    public String selectByCauserieAlias(String causerieAlias) {
        Causerie causerie = causerieMapper.selectByCauserieAlias(causerieAlias + ".html");
        if (causerie == null) {
            return Result.error("无此记录！");
        }
        return Result.success(causerie);
    }

    @Override
    public String selectDimByAll(String dimStr) {
        return Result.success(causerieMapper.selectDimByAll(dimStr));
    }

    @Override
    public String getCurrentAdjacentArticleByArticleAlias(String causerieAlias) {
        List<Causerie> causeries = causerieMapper.getCurrentAdjacentArticleByArticleAlias();
        // 保存结果
        Map<String, String> map = new HashMap<>();
        map.put("nextAlias", "");  // 初始值
        map.put("nextTitle", "");
        map.put("previousAlias", "");  // 初始值
        map.put("previousTitle", "");

        for (int i = 0; i < causeries.size(); i++) {
            Causerie causerie = causeries.get(i);
            // 如果找到传入的 articleAlias
            if (causerie.getCauserieAlias().equals(causerieAlias)) {
                // 获取上一条
                if (i != 0) {
                    map.put("previousAlias", causeries.get(i - 1).getCauserieAlias());
                    map.put("previousTitle", causeries.get(i - 1).getCauserieTitle());
                } else {
                    map.put("previousAlias", "");
                    map.put("previousTitle", "");
                }

                // 获取下一条
                if (i != causeries.size() - 1) {
                    map.put("nextAlias", causeries.get(i + 1).getCauserieAlias());
                    map.put("nextTitle", causeries.get(i + 1).getCauserieTitle());
                } else {
                    map.put("nextAlias", "");
                    map.put("nextTitle", "");
                }
                break;  // 退出循环
            }
        }
        return Result.success(map);
    }

    @Override
    public String selectByLatestRelease() {
        Causerie causerie = causerieMapper.selectByLatestRelease();
        if (causerie == null) {
            return Result.error("记录不存在！");
        }
        return Result.success(causerie);
    }

}
