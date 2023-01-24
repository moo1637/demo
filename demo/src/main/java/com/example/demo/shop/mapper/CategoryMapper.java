package com.example.demo.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.shop.model.Category;

@Mapper
public interface CategoryMapper {

	List<Category> selectCategoryList();
}
