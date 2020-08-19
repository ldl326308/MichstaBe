package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.Tag;
import com.lemon.michstabe.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tag", produces = "application/json;charset=utf-8")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    /**
     * 通过 TagId 删除一条记录
     *
     * @param tagId
     * @return
     */
    @DeleteMapping(path = "/{tagId}")
    public String deleteByPrimaryKey(@PathVariable("tagId") Integer tagId) {
        return tagService.deleteByPrimaryKey(tagId);
    }

    /**
     * 新增一条记录
     *
     * @param record
     * @return
     */
    @PostMapping
    public String insert(@RequestBody Tag record) {
        return tagService.insert(record);
    }

    /**
     * 根据 tagId 查询一条记录
     *
     * @param tagId
     * @return
     */
    @GetMapping(path = "/{tagId}")
    public String selectByPrimaryKey(@PathVariable("tagId") Integer tagId) {
        return tagService.selectByPrimaryKey(tagId);
    }

    /**
     * 分页查询记录
     *
     * @return
     */
    @GetMapping(path = "/page/{pageNum}")
    public String selectAll(@PathVariable("pageNum") Integer pageNum) {
        return tagService.selectTagByPageNum(pageNum);
    }


    /**
     * 查询所有记录
     *
     * @return
     */
    @GetMapping
    public String selectAll() {
        return tagService.selectAll();
    }

    /**
     * 修改记录信息
     *
     * @param record
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody Tag record) {
        return tagService.updateByPrimaryKey(record);
    }

    /**
     * 模糊查询Tag
     *
     * @param dimStr
     * @return
     */
    @GetMapping(path = "/dim")
    public String selectDimByAll(@RequestParam("dimStr") String dimStr) {
        return tagService.selectDimByAll(dimStr);
    }

}
