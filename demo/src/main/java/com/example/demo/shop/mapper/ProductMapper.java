package com.example.demo.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.shop.model.Product;

@Mapper
public interface ProductMapper {

	List<Product> selectProductList(Product param);
}
