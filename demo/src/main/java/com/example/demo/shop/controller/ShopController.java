package com.example.demo.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.shop.mapper.CategoryMapper;
import com.example.demo.shop.mapper.ProductMapper;
import com.example.demo.shop.model.Category;
import com.example.demo.shop.model.Product;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	CategoryMapper categoryMapper;
	
	@PostMapping("getProductList")
	public List<Product> getProductList(@RequestBody Product param) {
		return productMapper.selectProductList(param);
	}
	
	@GetMapping("getCategoryList")
	public List<Category> getCategoryList() {
		return categoryMapper.selectCategoryList();
	}
}
