package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import entity.Result;
import entity.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/5 20:08
 * @描述
 */
@RestController
@RequestMapping("specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;

    /**
     * 分页加条查
     * @param page
     * @param rows
     * @param specification
     * @return
     */
    @RequestMapping("selectPage")
    public PageResult selectPage(TbSpecification specification,int page,int rows){
        return specificationService.queryPage(page,rows,specification);
    }

    /**
     * 新增规格
     * @param specification
     * @return
     */
    @RequestMapping("insertSpecification")
    public Result insertSpecification(@RequestBody Specification specification){
        try {
            specificationService.insertSpecification(specification);
            return new Result(true,"新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败！");
        }
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("selectOne")
    public Specification selectOne(Long id){
       return specificationService.queryOne(id);
    }

    /**
     * 修改
     * @param specification
     * @return
     */
    @RequestMapping("updateSpecification")
    public Result updateSpecification(@RequestBody Specification specification){
        try {
            specificationService.updateSpecification(specification);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改失败！");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteAll")
    public Result deleteAll(Long[] ids){
        try {
            specificationService.deleteAll(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }

    /**
     * 关联规格展示下拉列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() throws Exception {

        return specificationService.selectOptionList();

    }

}
