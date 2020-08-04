package com.edu118.Controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.edu118.api.BaseController;
import com.edu118.api.MyResult;
import com.edu118.entity.Employee;
import com.edu118.service.IDeptService;
import com.edu118.service.IEmployeeService;

@Controller
public class TravelController extends BaseController{
	@Autowired
	private IEmployeeService employeeService;
	
	@Reference
	private IDeptService deptService;
	
	@GetMapping("/test")
	@RequiresPermissions("emp:add")
	@ResponseBody
	public MyResult Test() {
		List<Employee> employees = employeeService.findByExample(null, "");
		return MyResult.buildSuccess(employees);
	}
}
