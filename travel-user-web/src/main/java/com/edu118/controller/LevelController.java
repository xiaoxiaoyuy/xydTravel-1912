package com.edu118.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu118.api.BaseController;
import com.edu118.api.MyResult;
import com.edu118.entity.Level;
import com.edu118.service.LevelService;

@Controller
@RequestMapping("/level")
public class LevelController extends BaseController{
	@Autowired
	private LevelService levelService;

	@GetMapping("/findLevel")
	@ResponseBody  //把返回值序列化成JSON返回到页面的Body区域
	public MyResult findDeptData() {
		List<Level> levels = levelService.findAll();
		MyResult myResult = new MyResult();
		myResult.setData(levels);
		myResult.setMessage("数据查询完成！");
		return myResult;
	}
}
