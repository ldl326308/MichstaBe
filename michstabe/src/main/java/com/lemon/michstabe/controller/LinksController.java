package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.Links;
import com.lemon.michstabe.service.LinksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/links", produces = "application/json;charset=utf-8;")
public class LinksController {

    private final LinksService linksService;

    public LinksController(LinksService linksService) {
        this.linksService = linksService;
    }

    /**
     * 根据 linksId 删除一条记录
     * @param linksId
     * @return
     */
    @DeleteMapping("/{linksId}")
    public String deleteByPrimaryKey(@PathVariable("linksId") Integer linksId){
        return linksService.deleteByPrimaryKey(linksId);
    }

    /**
     * 新增条 links 记录
     * @param links
     * @return
     */
    @PostMapping
    public String insert(@RequestBody Links links){
        return linksService.insert(links);
    }

    /**
     * 根据 linksId 查询一条记录
     * @param linksId
     * @return
     */
    @GetMapping(path = "/{linksId}")
    public String selectByPrimaryKey(@PathVariable("linksId") Integer linksId){
        return linksService.selectByPrimaryKey(linksId);
    }

    /**
     * 分页查询
     * @param pageNum
     * @return
     */
    @GetMapping(path = "/page/{pageNum}")
    public String selectLinksByPage(@PathVariable("pageNum") Integer pageNum){
        return linksService.selectLinksByPage(pageNum);
    }

    /**
     * 根据 linksId 修改一个对象
     * @param links
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody Links links){
        return linksService.updateByPrimaryKey(links);
    }

    /**
     * 用于模糊搜索
     * @param dimStr 需要搜索的字符串
     * @return
     */
    @GetMapping(path = "/dim")
    public String selectDimByAll(@RequestParam("dimStr") String dimStr){
        return linksService.selectDimByAll(dimStr);
    }

    /**
     * 查询所有 Links 记录
     * @return
     */
    @GetMapping
    public String selectAllLinks(){
        return linksService.selectAll();
    }

}
