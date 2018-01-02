package com.purplesoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purplesoft.service.UserService;
import com.purplesoft.service.impl.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if(method.equals("getUserList")){
			getUserList(request,response);
		}else if(method.equals("save")){
			int n = 0;
			try {
				String json = request.getParameter("json");
				JSONArray jsonArray = JSONArray.fromObject(json);
				int count = jsonArray.size();
				for(int i = 0; i<jsonArray.size() ; i++){
					 JSONObject obj =jsonArray.getJSONObject(i);
					 if(obj.containsKey("addFlag")){
						 String username = obj.getString("username");
						 String age = obj.getString("age");
						 String sex = obj.getString("sex");
						 if(sex.equals("男")){
							 sex = "1";
						 }else {
							 sex = "2";
						 }
						 String birthday = obj.getString("birthday");
						 String city = obj.getString("city");
						 String salary = obj.getString("salary");
						 String starttime = obj.getString("starttime");
						 String endtime = obj.getString("endtime");
						 String description = obj.getString("description");
						 n = n + addSave(username,age,sex,birthday,city,salary,starttime,endtime,description);
					 }else {
						 String id = obj.getString("id");
						 String username = obj.getString("username");
						 String age = obj.getString("age");
						 String sex = obj.getString("sex");
						 if(sex.equals("男")){
							 sex = "1";
						 }else {
							 sex = "2";
						 }
						 String birthday = obj.getString("birthday");
						 String city = obj.getString("city");
						 String salary = obj.getString("salary");
						 String starttime = obj.getString("starttime");
						 String endtime = obj.getString("endtime");
						 String description = obj.getString("description");
						 n = n + editSave(id,username,age,sex,birthday,city,salary,starttime,endtime,description);
						 
					}
				}
				if(n==count){
					String res= "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
					response.getWriter().write(res);
				}else {
					String res= "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";
					response.getWriter().write(res);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}


	private int editSave(String id, String username, String age, String sex, String birthday, String city,
			String salary, String starttime, String endtime, String description) throws Exception  {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImpl();
		return userService.editSave(id,username, age, sex, birthday, city, salary, starttime, endtime, description);
	}


	private int addSave(String username, String age, String sex, String birthday, String city, String salary,
			String starttime, String endtime, String description) throws Exception {
		UserService userService = new UserServiceImpl();
		return userService.addSave(username, age, sex, birthday, city, salary, starttime, endtime, description);
		
	}


	private void getUserList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImpl();
		String pageSize = request.getParameter("pageSize");
		String pageCurrent = request.getParameter("pageCurrent");
		String resString = userService.getUserListByPage(pageSize, pageCurrent);
		try {
			response.getWriter().write(resString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
