package com.edu118.mapper;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.edu118.entity.Employee;

import tk.mybatis.mapper.common.Mapper;

//@Repository	//放入到spring容器中
public interface EmployeeMapper extends Mapper<Employee>{
	Set<String> findRolesByEid(Long did);
	Set<String> findPermissionByEid(Long did);
}