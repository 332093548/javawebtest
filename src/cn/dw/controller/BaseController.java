package cn.dw.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
	
	// mvc中可以自动的把request session application注入
	@Resource// 不用添加名称,系统会自动根据类型注入
	protected HttpServletRequest request;
	@Resource
	protected HttpSession session;
	@Resource
	protected ServletContext application;
}
