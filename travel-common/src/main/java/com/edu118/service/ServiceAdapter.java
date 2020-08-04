package com.edu118.service;

import java.util.List;

import com.github.pagehelper.Page;

import tk.mybatis.mapper.entity.Example;

public class ServiceAdapter<T, K> implements IBaseService<T, K>{

	@Override
	public int insertEntity(T entity) {
		return 0;
	}

	@Override
	public int updateEntity(T entity) {
		return 0;
	}

	@Override
	public int deleteEntity(T entity) {
		return 0;
	}

	@Override
	public T findById(K key) {
		return null;
	}

	@Override
	public List<T> findByExample(T entity, String flag) {
		return null;
	}

	@Override
	public List<T> findByExample(Example example, Page<T> page) {
		return null;
	}

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public List<T> queryPage(java.awt.print.Pageable pageable, Object... param) {
		return null;
	}

	@Override
	public long queryPageCount(java.awt.print.Pageable pageable, Object... param) {
		return 0;
	}
}



