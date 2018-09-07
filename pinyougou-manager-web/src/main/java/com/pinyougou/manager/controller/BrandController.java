package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author GAI
 * @创建人 yangfan zhang
 * @创建时间 2018/9/4 20:48
 * @描述
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Reference
    private BrandService brandService;


    /**
     * 分页查询
     * @param page
     * @param rows
     * @param brand
     * @return
     */
    @RequestMapping("queryBrand")
    public PageResult queryBrand(int page, int rows, TbBrand brand){
        PageResult pageResult = brandService.findPage(page,rows,brand);
        System.out.println(pageResult);
        return pageResult;
    }

    /**
     * 新增品牌
     * @param brand
     * @return
     */
    @RequestMapping("insertBrand")
    public Result insertBrand(@RequestBody TbBrand brand){
        try {
            brandService.insertBrand(brand);
            return new Result(true,"新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"新增失败！");
        }
    }

    /**
     * 回显（根据id查询品牌信息）
     * @param id
     * @return
     */
    @RequestMapping("queryBrandById")
    public TbBrand queryBrandById(Integer id){
        return brandService.queryBrandById(id);
    }

    /**
     * 修改商品信息
     * @param brand
     * @return
     */
    @RequestMapping("updateBrand")
    public Result updateBrand(@RequestBody TbBrand brand){
        try {
            brandService.updateBrand(brand);
            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"修改成功！");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("deleteBrandAll")
    public Result deleteBrandAll(String ids){
        try {
            brandService.deleteBrandAll(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除成功！");
        }
    }

    /**
     * 下拉列表数据展示
     * @return
     */
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }

}
