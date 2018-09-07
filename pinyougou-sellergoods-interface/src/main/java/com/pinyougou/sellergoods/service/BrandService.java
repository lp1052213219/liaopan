package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;

public interface BrandService {

	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @param brand
     * @return
     */
	PageResult findPage(int page, int rows,TbBrand brand);

	/**
	 * 新增商品品牌
	 * @param brand
     */
	void insertBrand(TbBrand brand);

	/**
	 * 回显（根据id查询商品品牌信息）
	 * @param id
	 * @return
     */
	TbBrand queryBrandById(Integer id);

	/**
	 * 修改商品品牌
	 * @param brand
     */
	void updateBrand(TbBrand brand);

	/**
	 * 批量删除商品品牌
	 * @param ids
     */
	void deleteBrandAll(String ids);

	/**
	 * 下拉列表数据展示
	 * @return
     */
	List<Map> selectOptionList();
}
