package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/6 14:40
 * @描述
 */
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService{

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Override
    public PageResult selectPage(int page, int rows, TbTypeTemplate typeTemplate) {
        PageHelper.startPage(page, rows);
        TbTypeTemplateExample typeTemplateExample = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = typeTemplateExample.createCriteria();
        if(typeTemplate!=null){
            if(typeTemplate.getName()!=null && typeTemplate.getName().length()>0){
                criteria.andNameLike("%"+typeTemplate.getName()+"%");
            }
        }
        Page<TbTypeTemplate> p= (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(typeTemplateExample);

        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public void insertTypeTemplate(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.insert(typeTemplate);
    }

    @Override
    public TbTypeTemplate selectOne(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTypeTemplate(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    @Override
    public void deleteTypeTemplateAll(Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            typeTemplateMapper.deleteByPrimaryKey(ids[i]);
        }
    }
}
