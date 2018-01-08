package com.purplesoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purplesoft.service.SjzbService;
import com.purplesoft.service.impl.SjzbServiceImpl;

public class SjzbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String method = request.getParameter("method");
		if(method.equals("getTree")){
			System.out.println(request.getParameter("id") + "  " + request.getParameter("name") + "   " + request.getParameter("otherParam"));
			getTree(request,response);
		}else if(method.equals("addtree")){
			addTree(request,response);
		}
	}


	private void addTree(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		String pid = request.getParameter("pid");
		String name = request.getParameter("name");
		sjzbService.addTree(pid,name);
	}


	private void getTree(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		String pid = request.getParameter("id");
		String tree = "";
		if(pid==null || pid==""){
			tree = sjzbService.getTree();
		}else{
			tree = sjzbService.getTreeByPid(pid);
		}
		
		try {
			System.out.println(tree);
			response.getWriter().write(tree);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
