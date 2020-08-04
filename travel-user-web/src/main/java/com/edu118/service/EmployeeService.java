package com.edu118.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.edu118.entity.Employee;
import com.edu118.mapper.EmployeeMapper;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Component
@Service
public class EmployeeService extends ServiceAdapter<Employee, String> 
				implements IEmployeeService{
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> findByExample(Employee emp,String flag){
		Example example = new Example(Employee.class);
		example.excludeProperties("password");
		Criteria criteria = example.createCriteria();
		//登陆的操作，以用户名和密码进行查询，构建出查询的条件
		if("login".equals(flag)) {
			criteria.andEqualTo("eid", emp.getEid()).andEqualTo("password", emp.getPassword());
		}
		return employeeMapper.selectByExample(example);
	}
	
	//查询用户的角色和权限
	@Override
	public Map<String,Set<String>> findRolesAndPermissionsByDid(Long did) {
		Set<String> roles = employeeMapper.findRolesByEid(did);
		Set<String> permissions = employeeMapper.findPermissionByEid(did);
		HashMap<String, Set<String>> map = new HashMap<>();
		map.put("roles", roles);
		map.put("permissions", permissions);
		System.out.println("roles="+roles);
		System.out.println("permissions="+permissions);
		return map;  //把查询到的数据，以Map的形式进行返回
	}
	
	@Override
	public int insertEntity(Employee entity) {
		return employeeMapper.insertSelective(entity);
	}
}
