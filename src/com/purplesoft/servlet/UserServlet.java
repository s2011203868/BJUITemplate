package com.purplesoft.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.purplesoft.pojo.User;
import com.purplesoft.service.UserService;
import com.purplesoft.service.impl.UserServiceImpl;
import com.purplesoft.util.UploadUtil;
import com.purplesoft.util.XSSFDateUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		}else if(method.equals("del")){
			String ids = request.getParameter("id");
			String [] idArray = ids.split(",");
			delUser(idArray,request,response);
		}else if(method.equals("downloadTemplate")){
			downLoadTempalte(request,response);
		}else if(method.equals("upload")){
			importData(request,response);
		}
	}



	private void importData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HashMap<String,FileItem> map = UploadUtil.getFileItem(request);
		String first = map.get("first").getString();
		try {
			InputStream is = map.get("upfile").getInputStream();
			String fileName = map.get("upfile").getName();
			String path = request.getSession().getServletContext().getRealPath("/");
			File file = new File(path+"Temp");
			
			if(!file.exists()){
				file.mkdirs();
			}
			File upfile = new File(file+"\\"+fileName);
			FileUtils.copyInputStreamToFile(is, upfile);
			List<User> list = ReadXls(upfile,first);
			UserService userService = new UserServiceImpl();
			int n = userService.insertByList(list);
			if(n==list.size()){
				String res= "{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\"}";
				response.getWriter().write(res);	
			}else{
				String res= "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";
				response.getWriter().write(res);
			}
			
		} catch (Exception e) {
			
			try {
				String res= "{\"statusCode\":\"300\",\"message\":\"操作失败\"}";
				response.getWriter().write(res);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}


	private List<User> ReadXls(File upfile,String first) {
		int index = Integer.parseInt(first)-1;
		List<User> list = new ArrayList<User>();
		try {
			FileInputStream fis = new FileInputStream(upfile);
			Workbook workBook = WorkbookFactory.create(fis);
			int sheetNumber = workBook.getNumberOfSheets();
			for(int i = 0 ; i<sheetNumber ; i++){
				Sheet sheet = workBook.getSheetAt(i);
				int rowNum = sheet.getPhysicalNumberOfRows();
				for(int j = index ; j<rowNum ; j++){
					User user = new User();
					Row row = sheet.getRow(j);
					int cellNum = row.getPhysicalNumberOfCells();
					for(int x = 0 ; x<cellNum ; x++){
						Cell cell = row.getCell(x);
						if(x==0){
							user.setUsername(XSSFDateUtil.getStringCellValue(cell).trim());
						}
						if(x==1){
							user.setAge(Integer.parseInt(XSSFDateUtil.getStringCellValue(cell).trim().substring(0,XSSFDateUtil.getStringCellValue(cell).trim().indexOf("."))));
						}
						if(x==2){
							user.setSex(Integer.parseInt(XSSFDateUtil.getStringCellValue(cell).trim().substring(0,XSSFDateUtil.getStringCellValue(cell).trim().indexOf("."))));
						}
						if(x==3){
							user.setBirthday(XSSFDateUtil.getStringCellValue(cell).trim());
						}
						if(x==4){
							user.setCity(Integer.parseInt(XSSFDateUtil.getStringCellValue(cell).trim().substring(0,XSSFDateUtil.getStringCellValue(cell).trim().indexOf("."))));
						}
						if(x==5){
							user.setSalary(Double.parseDouble(XSSFDateUtil.getStringCellValue(cell).trim()));
						}
						if(x==6){
							user.setStarttime(XSSFDateUtil.getStringCellValue(cell).trim());
						}
						if(x==7){
							user.setEndtime(XSSFDateUtil.getStringCellValue(cell).trim());
						}
						if(x==8){
							user.setAge(Integer.parseInt(XSSFDateUtil.getStringCellValue(cell).trim().substring(0,XSSFDateUtil.getStringCellValue(cell).trim().indexOf("."))));
						}
						if(x==9){
							user.setDescription(XSSFDateUtil.getStringCellValue(cell).trim());
						}
					}
					list.add(user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		// TODO Auto-generated method stub
		
	}


	private void downLoadTempalte(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("/");
		File file = new File(path+"resource\\Template.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ServletOutputStream sos = response.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(sos);
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String fileName = date + ".xlsx";
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			
			
			int len = 0;
			byte [] b = new byte [1024];
			while((len = bis.read(b))!=-1){
				bos.write(b, 0, len);
			}
			bos.flush();
			bos.close();
			sos.close();
			bis.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void delUser(String[] idArray, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImpl();
		int n = 0;
		 try {
			n = n + userService.delUser(idArray);
			int count = idArray.length;
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
