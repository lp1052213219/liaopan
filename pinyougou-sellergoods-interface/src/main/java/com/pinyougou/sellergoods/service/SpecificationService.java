package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import entity.PageResult;
import entity.Specification;

import java.util.List;
import java.util.Map;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/5 19:19
 * @描述
 */
public interface SpecificationService {

    /**
     * 分页查询加条查
     * @param page
     * @param rows
     * @param specification
     * @return
     */
    PageResult queryPage(int page,int rows,TbSpecification specification);

    /**
     * 新增规格
     * @param specification
     */
    void insertSpecification(Specification specification);

    /**
     *  回显
     * @param id 规格id
     * @return
     */
    Specification queryOne(Long id);


    /**
     * 修改规格
     * @param specification
     */
    void updateSpecification(Specification specification);

    /**
     * 批量删除
     * @param ids
     */
    void deleteAll(Long[] ids);

    /**
     * 关联规格展示
     * @return
     */
    List<Map> selectOptionList();
}
