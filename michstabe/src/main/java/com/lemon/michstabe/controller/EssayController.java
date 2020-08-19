package com.lemon.michstabe.controller;

import com.lemon.michstabe.entity.Essay;
import com.lemon.michstabe.service.EssayService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/essay", produces = "application/json;charset=utf-8;")
public class EssayController {

    private final EssayService essayService;

    public EssayController(EssayService essayService) {
        this.essayService = essayService;
    }

    /**
     * 通过 essayId 删除一条记录
     * @param essayId
     * @return
     */
    @DeleteMapping("/{essayId}")
    public String deleteByPrimaryKey(@PathVariable("essayId") Integer essayId){
        return essayService.deleteByPrimaryKey(essayId);
    }

    /**
     * 增加一条新的 essay 记录
     * @param essay
     * @return
     */
    @PostMapping
    public String insert(@RequestBody Essay essay){
        return essayService.insert(essay);
    }

    /**
     * 通过 essayId 查询记录
     * @param essayId
     * @return
     */
    @GetMapping(path = "/{essayId}")
    public String selectByPrimaryKey(@PathVariable("essayId") Integer essayId){
        return essayService.selectByPrimaryKey(essayId);
    }

    /**
     * 分页查询
     * @param pageNum
     * @return
     */
    @GetMapping(path = "/page/{pageNum}")
    public String selectEssayByPage(@PathVariable("pageNum") Integer pageNum){
        return essayService.selectAll(pageNum);
    }

    /**
     * 用于修改 essay 记录
     * @param essay
     * @return
     */
    @PutMapping
    public String updateByPrimaryKey(@RequestBody Essay essay){
        return essayService.updateByPrimaryKey(essay);
    }

    /**
     * 用于模糊搜索
     * @param dimStr 需要搜索的字符串
     * @return
     */
    @GetMapping(path = "/dim")
    public String selectDimByAll(@RequestParam("dimStr") String dimStr){
        return essayService.selectDimByAll(dimStr);
    }


}
