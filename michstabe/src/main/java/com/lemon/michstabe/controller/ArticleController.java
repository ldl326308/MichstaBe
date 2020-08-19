package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.Article;
import com.lemon.michstabe.service.ArticleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/article", produces = "application/json;charset=utf-8")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 通过 articleId 删除一条记录
     * @param articleId
     * @return
     */
    @DeleteMapping(path = "/{articleId}")
    public String deleteByPrimaryKey(@PathVariable("articleId") String articleId){
        return articleService.deleteByPrimaryKey(articleId);
    }

    /**
     * 添加一条记录
     * @param record
     * @return
     */
    @PostMapping
    public String insert(@RequestBody Article record){
        return articleService.insert(record);
    }

    /**
     * 通过 articleAlias 获取一条信息
     * @param articleAlias
     * @return
     */
    @GetMapping("/{articleAlias}")
    public String clientGetArticleByArticleAlias(@PathVariable("articleAlias") String articleAlias, @RequestParam(name = "articleProtect", defaultValue = "") String articleProtect){
        return articleService.clientGetArticleByArticleAlias(articleAlias, articleProtect);
    }

    /**
     * 管理员无限制通过 articleAlias 查询记录
     * @param articleAlias
     * @return
     */
    @GetMapping("/manager/{articleAlias}")
    public String managerGetArticleByArticleAlias(@PathVariable("articleAlias") String articleAlias){
        return articleService.managerGetArticleByArticleAlias(articleAlias);
    }


    /**
     * 分页查询记录，每页10条记录
     * @param pageNum
     * @return
     */
    @GetMapping(path = "/page/{pageNum}")
    public String selectAll(@PathVariable("pageNum") Integer pageNum){
        return articleService.selectAll(pageNum);
    }

    /**
     * 分页查询记录，只显示简单的信息
     * @param pageNum
     * @return
     */
    @GetMapping(path = "/basic/page/{pageNum}")
    public String selectArticleByPageToBasic(@PathVariable("pageNum") Integer pageNum){
        return articleService.selectArticleByPageToBasic(pageNum);
    }

    /**
     * 修改记录
     * @param record
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody Article record){
        return articleService.updateByPrimaryKey(record);
    }


    /**
     *
     * @param dimStr
     * @return
     */
    @GetMapping(path = "/dim")
    public String selectDimByAll(@RequestParam("dimStr") String dimStr){
        return articleService.selectDimByAll(dimStr);
    }

    /**
     * 传入一个 articleAlias 获取此记录相邻的两条记录
     * @param articleAlias
     * @return
     */
    @GetMapping("/adjacent")
    public String getCurrentAdjacentArticleByArticleAlias(@RequestParam("articleAlias") String articleAlias){
        return articleService.getCurrentAdjacentArticleByArticleAlias(articleAlias);
    }

}
