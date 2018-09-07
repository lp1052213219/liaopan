package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import entity.PageResult;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/6 14:15
 * @描述
 */
public interface TypeTemplateService {

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param typeTemplate
     * @return
     */
    PageResult selectPage(int page, int rows, TbTypeTemplate typeTemplate);

    /**
     * 添加模版
     * @param typeTemplate
     */
    void insertTypeTemplate(TbTypeTemplate typeTemplate);

    /**
     * 回显
     * @param id
     * @return
     */
    TbTypeTemplate selectOne(Long id);

    /**
     * 修改模版信息
     * @param typeTemplate
     */
    void updateTypeTemplate(TbTypeTemplate typeTemplate);

    /**
     * 批量删除
     * @param ids
     */
    void deleteTypeTemplateAll(Long[] ids);
}
