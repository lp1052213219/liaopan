package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import entity.Specification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/5 19:34
 * @描述
 */
@Service
public class SpecificationServiceImpl implements SpecificationService{

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public PageResult queryPage(int page, int rows, TbSpecification specification) {
        PageHelper.startPage(page, rows);
        TbSpecificationExample specificationExample = new TbSpecificationExample();
        TbSpecificationExample.Criteria criteria = specificationExample.createCriteria();
        if(specification != null){
            if(specification.getSpecName()!=null && specification.getSpecName().length() > 0){
                criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
            }
        }
        Page<TbSpecification> p = (Page<TbSpecification>) specificationMapper.selectByExample(specificationExample);
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public void insertSpecification(Specification specification) {
        specificationMapper.insert(specification.getSpecification());
        long specId = specification.getSpecification().getId();
        System.out.println(specId);
        for (int i = 0; i < specification.getSpecificationOptionList().size(); i++) {
            TbSpecificationOption specificationOption = new TbSpecificationOption();
            specificationOption.setOptionName(specification.getSpecificationOptionList().get(i).getOptionName());
            specificationOption.setOrders(specification.getSpecificationOptionList().get(i).getOrders());
            specificationOption.setSpecId(specId);
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public Specification queryOne(Long id) {
        Specification specification = new Specification();
        specification.setSpecification(specificationMapper.selectByPrimaryKey(id));

        TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(id);
        specification.setSpecificationOptionList(specificationOptionMapper.selectByExample(specificationOptionExample));
        return specification;
    }

    @Override
    public void updateSpecification(Specification specification) {
        specificationMapper.updateByPrimaryKey(specification.getSpecification());

        TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());

        specificationOptionMapper.deleteByExample(specificationOptionExample);

        for (int i = 0; i < specification.getSpecificationOptionList().size(); i++) {
            TbSpecificationOption specificationOption = new TbSpecificationOption();
            specificationOption.setOptionName(specification.getSpecificationOptionList().get(i).getOptionName());
            specificationOption.setOrders(specification.getSpecificationOptionList().get(i).getOrders());
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public void deleteAll(Long[] ids) {

        for (int i = 0; i <ids.length ; i++) {
            specificationMapper.deleteByPrimaryKey(ids[i]);

            TbSpecificationOptionExample specificationOptionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = specificationOptionExample.createCriteria();
            criteria.andSpecIdEqualTo(ids[i]);
            specificationOptionMapper.deleteByExample(specificationOptionExample);
        }

    }

    @Override
    public List<Map> selectOptionList() {
        return specificationMapper.selectOptionList();
    }
}
