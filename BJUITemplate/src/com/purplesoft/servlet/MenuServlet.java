package com.purplesoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purplesoft.service.MenuService;
import com.purplesoft.service.impl.MenuServiceImpl;

public class MenuServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		
		if(method.equals("getmenulist")){
			getMenuList(request,response);
		}
	}


	private void getMenuList(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		MenuService menuService = new MenuServiceImpl();
		String zid = request.getParameter("zid");
		String json = menuService.getMenuListByZid(Integer.parseInt(zid));
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
