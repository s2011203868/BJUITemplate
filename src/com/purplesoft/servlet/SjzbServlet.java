package com.purplesoft.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purplesoft.dao.SjzbDao;
import com.purplesoft.dao.impl.SjzbDaoImpl;
import com.purplesoft.service.SjzbService;
import com.purplesoft.service.impl.SjzbServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SjzbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String method = request.getParameter("method");
		if (method.equals("getTree")) {
			System.out.println(request.getParameter("id") + "  " + request.getParameter("name") + "   "
					+ request.getParameter("otherParam"));
			getTree(request, response);
		} else if (method.equals("addtree")) {
			addTree(request, response);
		} else if (method.equals("modifyname")) {
			reTreeName(request, response);
		} else if (method.equals("delTree")) {
			delTree(request, response);
		}
	}

	private void delTree(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		SjzbDao sjzbDao = new SjzbDaoImpl();
		String id = request.getParameter("id");
		String pid = sjzbDao.getIdByPid(id);
		List<Map<String, Object>> lists = sjzbDao.getChildren(pid);
		if (lists.size() <= 1) {
			sjzbDao.updateParentToFalse(pid);
		}
		sjzbService.delTree(id);

	}

	private void reTreeName(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		sjzbService.reName(id, name);
	}

	private void addTree(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		String pid = request.getParameter("pid");
		String name = request.getParameter("name");
		StringBuffer formdata = new StringBuffer();
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");
		String salary = request.getParameter("salary");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String description = request.getParameter("description");
		if (username != null) {
			formdata.append("," + username);
		}
		if (age != null) {
			formdata.append("," + age);
		}
		if (sex != null) {
			formdata.append("," + sex);
		}
		if (birthday != null) {
			formdata.append("," + birthday);
		}
		if (city != null) {
			formdata.append("," + city);
		}
		if (salary != null) {
			formdata.append("," + salary);
		}
		if (starttime != null) {
			formdata.append("," + starttime);
		}
		if (endtime != null) {
			formdata.append("," + endtime);
		}
		if (description != null) {
			formdata.append("," + description);
		}
		String data = "";
		if (formdata.toString().startsWith(",")) {
			data = formdata.toString().substring(1, formdata.toString().length());
		} else {
			data = formdata.toString();
		}
		if (pid != null || pid != "") {
			sjzbService.addTree(pid, name,data);
		}
	}

	private void getTree(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SjzbService sjzbService = new SjzbServiceImpl();
		String pid = request.getParameter("id");
		String tree = "";
		if (pid == null || pid == "") {
			tree = sjzbService.getTree();
		} else {
			tree = sjzbService.getTreeByPid(pid);
		}

		try {
			System.out.println(tree);
			response.getWriter().write(tree);
		} catch (IOException e) {
			// TODO Ato-generated catch block
			e.printStackTrace();
		}
	}

}
