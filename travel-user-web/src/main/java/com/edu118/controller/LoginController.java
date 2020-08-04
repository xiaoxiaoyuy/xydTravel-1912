package com.edu118.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu118.api.BaseController;
import com.edu118.entity.Employee;
import com.edu118.validateGroup.ILoginGroups;

@Controller
public class LoginController extends BaseController{
	//通过日志输出相应的数据
	Logger logger = LogManager.getLogger(LoginController.class);
	
	@GetMapping("/test")
	@RequiresPermissions("emp:add")
	public ModelAndView addEmp(HttpServletRequest request) {
		String sessionId = request.getHeader("xydLoginToke");
		System.out.println("测试，Session共享，请求头的SessionId="+sessionId);
		return null;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Validated(ILoginGroups.class) Employee emp,HttpSession session) {
		//logger.info("登陆数据：Employee = " + emp);
		logger.info("登陆数据：{}", emp);
		ModelAndView mav = new ModelAndView("pages/index.jsp");
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(emp.getEid(),emp.getPassword());
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			
			//登录成功，保存sessionId到Session域
			String sessionId = subject.getSession().getId().toString();
			session.setAttribute("loginSessionId", sessionId);
			System.out.println("登录成功，生成的sessionId="+sessionId);
		}catch(Exception e){
			//登陆验证失败，用户被锁定或者用户名密码错误
			mav.addObject("logMsg",e.getMessage());
			mav.setViewName("login.jsp");
		}
		//登录成功，进入到index.jsp页面
		return mav;
	}
}
