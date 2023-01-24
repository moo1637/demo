package com.example.demo.shop.model;

public class Category {
	private String id;
	private String parentId;
	private String name;
	private String depth;
	private String sort;
	 
	
	public Category(String id, String parentId, String name, String depth, String sort) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.depth = depth;
		this.sort = sort;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
