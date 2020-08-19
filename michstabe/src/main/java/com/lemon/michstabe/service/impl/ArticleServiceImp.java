package com.lemon.michstabe.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lemon.michstabe.dao.ArticleMapper;
import com.lemon.michstabe.dto.DateUtil;
import com.lemon.michstabe.dto.RandomUtil;
import com.lemon.michstabe.dto.Result;
import com.lemon.michstabe.entity.Article;
import com.lemon.michstabe.entity.TagRelationArticle;
import com.lemon.michstabe.service.ArticleService;
import com.lemon.michstabe.service.TagRelationArticleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ArticleServiceImp implements ArticleService {

    private final ArticleMapper articleMapper;

    private final TagRelationArticleService tagRelationArticleService;

    public ArticleServiceImp(ArticleMapper articleMapper, TagRelationArticleService tagRelationArticleService) {
        this.articleMapper = articleMapper;
        this.tagRelationArticleService = tagRelationArticleService;
    }

    @Override
    public String deleteByPrimaryKey(String articleId) {
        // 删除 article及与tag的中间表记录 记录
        int count = articleMapper.deleteByPrimaryKey(articleId);
        if (count == 0) {
            return Result.error("删除记录失败！");
        }
        return Result.success("删除记录成功！");
    }

    @Override
    public String insert(Article record) {
        // 生成一个 UUID，用于articleId
        String articleId = UUID.randomUUID().toString();
        record.setArticleId(articleId);

        // 数据初始化
        // 生成别名
        String alias = "";
        for (int i = 0; i < 100; i++) {
            // 生成 alias
            alias = String.valueOf(RandomUtil.randomInt(100, 1000)) + ".html";

            // 判断 alias 是否已存在
            Article article = articleMapper.selectByArticleAlias(alias);
            if (article == null) {
                // 设置别名
                record.setArticleAlias(alias);
                break;
            }

        }
        // private String articleImg;  暂时不管，保留

        // 设置 basic
        if (record.getArticleBasic().length() > 80) {
            record.setArticleBasic(record.getArticleBasic().substring(0, 80));
        }

        // 设置创建时间
        record.setArticleCreateDate(DateUtil.getNowDate());

        // 设置修改时间
        record.setArticleLastUpdateDate(DateUtil.getNowDatetime());

        // insert tag and article relation table
        int count = articleMapper.insert(record);
        if (count == 0) {
            return Result.error("新增记录失败！");
        }

        // 添加 tag 与 article 的记录
        if (record.getTags().size() > 0) {
            if (tagRelationArticleService.inserts(articleId, record.getTags()) == false) {
                return Result.error("新增记录失败！");
            }
        }

        return Result.success("新增记录成功！");
    }

    @Override
    public String clientGetArticleByArticleAlias(String articleAlias, String articleProtect) {
        // 通过 alias 查询 Article 记录
        Article article = articleMapper.selectByArticleAlias(articleAlias + ".html");
        // 如果查询为空，返回未查询到记录 code 300
        if (article == null) {
            return Result.error("记未查询到此记录！");
        }
        // 如果查询到记录，且文章公开不需要密码可直接访问，返回结果 code 200
        if (article.getArticleProtect().length() == 0 | article.getArticleProtect() == null) {
            return Result.success(article);
        }

        // 查询到记录，需要密码验证，通过才可访问 code 201
        if (article.getArticleProtect().length() > 0 & articleProtect.equals("")) {
            return Result.success("文章加密，请输入密码访问~");
        }

        // 记录需要密码访问，且前台带密码请求，进行密码验证不通过 code 303
        if (article.getArticleProtect().length() > 0 & !articleProtect.equals(article.getArticleProtect())) {
            return Result.info(303, "密码验证不通过！", null);
        }

        // 记录需要密码访问，且前台带密码请求，进行密码验证通过 code 200
        if (article.getArticleProtect().length() > 0 & articleProtect.equals(article.getArticleProtect())) {
            return Result.success("密码验证通过。", article);
        }

        return Result.error("这是个BUG哦！");
    }

    @Override
    public String managerGetArticleByArticleAlias(String articleAlias) {
        // 通过 alias 查询 Article 记录
        Article article = articleMapper.selectByArticleAlias(articleAlias + ".html");
        // 如果查询为空，返回未查询到记录 code 300
        if (article == null) {
            return Result.error("记未查询到此记录！");
        }

        return Result.success(article);
    }

    @Override
    public String selectAll(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Article> articles = articleMapper.selectAll();
        PageInfo<Article> articlePageInfo = new PageInfo<>(articles);
        return Result.success(articlePageInfo);
    }

    @Override
    public String selectArticleByPageToBasic(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Article> articles = articleMapper.selectArticleByPageToBasic();
        PageInfo<Article> info = new PageInfo<>(articles);
        return Result.success(info);
    }

    @Override
    public String updateByPrimaryKey(Article record) {
        // 删除所有关联 articleId 的关系表记录
        boolean bool = tagRelationArticleService.deleteByArticleId(record.getArticleId());
        if (bool == false) {
            return Result.error("修改记录失败！");
        }

        // 添加 article 关联的 tag
        if (record.getTags().size() > 0) {
            boolean insertBool = tagRelationArticleService.inserts(record.getArticleId(), record.getTags());
            if (insertBool == false) {
                return Result.error("修改记录失败！");
            }
        }

        if (record.getArticleBasic().length() > 80) {
            record.setArticleBasic(record.getArticleBasic().substring(0, 80));
        }

        // 将最后修改时间改为当前时间
        record.setArticleLastUpdateDate(DateUtil.getNowDatetime());

        // 修改 article 信息
        int count = articleMapper.updateByPrimaryKey(record);
        if (count == 0) {
            return Result.error("修改记录失败！");
        }

        return Result.success("修改记录成功！");
    }

    @Override
    public String selectByArticleAlias(String articleAlias) {
        Article article = articleMapper.selectByArticleAlias(articleAlias);
        if (article == null) {
            return Result.success("记录不存在！");
        }
        return Result.success(article);
    }

    @Override
    public String selectDimByAll(String dimStr) {
        return Result.success(articleMapper.selectDimByAll(dimStr));
    }

    @Override
    public String getCurrentAdjacentArticleByArticleAlias(String articleAlias) {
        List<Article> articles = articleMapper.getCurrentAdjacentArticleByArticleAlias();
        // 保存结果
        Map<String, String> map = new HashMap<>();
        map.put("nextAlias", "");  // 初始值
        map.put("nextTitle", "");
        map.put("previousAlias", "");  // 初始值
        map.put("previousTitle", "");

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            // 如果找到传入的 articleAlias
            if (article.getArticleAlias().equals(articleAlias)) {
                // 获取上一条
                if (i != 0) {
                    map.put("nextAlias", articles.get(i - 1).getArticleAlias());
                    map.put("nextTitle", articles.get(i - 1).getArticleTitle());
                } else {
                    map.put("nextAlias", "");
                    map.put("nextTitle", "");
                }

                // 获取下一条
                if (i != articles.size() - 1) {
                    map.put("previousAlias", articles.get(i + 1).getArticleAlias());
                    map.put("previousTitle", articles.get(i + 1).getArticleTitle());
                } else {
                    map.put("previousAlias", "");
                    map.put("previousTitle", "");
                }
                break;  // 退出循环
            }
        }
        return Result.success(map);
    }
}
