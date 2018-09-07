package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/6 14:36
 * @描述
 */
@RestController
@RequestMapping("typeTemplate")
public class TypeTemplateController {

    @Reference
    private TypeTemplateService typeTemplateService;

    /**
     * 分页列表查看
     * @param page
     * @param rows
     * @param typeTemplate
     * @return
     */
    @RequestMapping("selectPage")
    public PageResult selectPage(int page,int rows,TbTypeTemplate typeTemplate){
        return typeTemplateService.selectPage(page,rows,typeTemplate);
    }

    /**
     * 新增分类模版
     * @param typeTemplate
     * @return
     */
    @RequestMapping("insertTypeTemplate")
    public Result insertTypeTemplate(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.insertTypeTemplate(typeTemplate);
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
    public TbTypeTemplate selectOne(Long id){
        return typeTemplateService.selectOne(id);
    }

    /**
     * 修改
     * @param typeTemplate
     * @return
     */
    @RequestMapping("updateTypeTemplate")
    public Result updateTypeTemplate(@RequestBody TbTypeTemplate typeTemplate){
        try {
            typeTemplateService.updateTypeTemplate(typeTemplate);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败！");
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
            typeTemplateService.deleteTypeTemplateAll(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
           return new Result(false,"删除失败！");
        }
    }

}
