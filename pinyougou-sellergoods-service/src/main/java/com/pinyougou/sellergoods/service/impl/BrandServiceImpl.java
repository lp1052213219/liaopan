package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @创建人 yangfan zhang
 * @创建时间 2018/9/4 20:19
 * @描述
 */
@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public PageResult findPage(int page, int rows, TbBrand brand) {
        PageHelper.startPage(page,rows);
        Page<TbBrand> p = (Page<TbBrand>) brandMapper.queryFindPage(brand);
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public void insertBrand(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public TbBrand queryBrandById(Integer id) {
        return brandMapper.selectByPrimaryKey((long)id);
    }

    @Override
    public void updateBrand(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void deleteBrandAll(String ids) {
        String[] id = ids.split(",");
        for (int i = 0;i < id.length;i++){
            brandMapper.deleteByPrimaryKey(Long.parseLong(id[i]));
        }
    }

    @Override
    public List<Map> selectOptionList() {

        return brandMapper.selectOptionList();
    }


}
