package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.Causerie;
import com.lemon.michstabe.service.CauserieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/causerie")
public class CauserieController {

    private final CauserieService causerieService;

    public CauserieController(CauserieService causerieService) {
        this.causerieService = causerieService;
    }

    /**
     * 根据 causerieId 删除一条记录
     *
     * @param causerieId
     * @return
     */
    @DeleteMapping("/{causerieId}")
    public String deleteByPrimaryKey(@PathVariable("causerieId") Integer causerieId) {
        return causerieService.deleteByPrimaryKey(causerieId);
    }

    /**
     * 新增一条记录
     * @param record
     * @return
     */
    @PostMapping
    public String insert(@RequestBody Causerie record) {
        return causerieService.insert(record);
    }

    /**
     * 根据 causerieId 查询一条记录
     * @param causerieAlias
     * @return
     */
    @GetMapping(value = "/{causerieAlias}")
    public String selectByCauserieAlias(@PathVariable("causerieAlias") String causerieAlias) {
        return causerieService.selectByCauserieAlias(causerieAlias);
    }

    /**
     * 查询所有记录
     * @return
     */
    @GetMapping(path = "/page/{pageNum}")
    public String selectAll(@PathVariable("pageNum") Integer pageNum) {
        return causerieService.selectAll(pageNum);
    }

    /**
     * 根据 causerId 修改一条记录
     * @param record
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody Causerie record) {
        return causerieService.updateByPrimaryKey(record);
    }

    /**
     * 模糊查询
     * @param dimStr
     * @return
     */
    @GetMapping(path = "/dim")
    public String selectDimByAll(@RequestParam("dimStr") String dimStr){
        return causerieService.selectDimByAll(dimStr);
    }

    /**
     * 根据 causerieAlias 查询此记录的上一条与下一条记录
     * @param causerieAlias
     * @return
     */
    @GetMapping("/adjacent")
    public String getCurrentAdjacentArticleByArticleAlias(@RequestParam("causerieAlias") String causerieAlias){
        return causerieService.getCurrentAdjacentArticleByArticleAlias(causerieAlias);
    }

    /***
     * 查询最新的一条记录
     * @return
     */
    @GetMapping(value = "/latest")
    public String selectByLatestRelease(){
        return causerieService.selectByLatestRelease();
    }

}
