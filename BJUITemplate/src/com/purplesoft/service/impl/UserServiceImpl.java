package com.purplesoft.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.basedao.impl.BaseDaoImp;
import com.purplesoft.dao.UserDao;
import com.purplesoft.dao.impl.UserDaoImpl;
import com.purplesoft.pojo.User;
import com.purplesoft.service.UserService;

import net.sf.json.JSONArray;

public class UserServiceImpl implements UserService {

	@Override
	public String getUserList() {
		UserDao userDao = new UserDaoImpl();
		List<Map<String, Object>> userList = userDao.getUserList();
		List<User> uList = new ArrayList<User>();
		for(Map<String,Object> map : userList){
			Set<String> keySet = map.keySet();
			User user = new User();
			for(String str :keySet ){
				if(str.equals("id")){
					user.setId(Integer.parseInt(map.get("id")+""));
				}else if(str.equals("username")){
					user.setUsername(map.get("username")+"");
				}else if(str.equals("age")){
					user.setAge(Integer.parseInt(map.get("age")+""));
				}else if(str.equals("sex")){
					user.setSex(Integer.parseInt(map.get("sex")+""));;
				}else if(str.equals("birthday")){
					user.setBirthday(map.get("birthday")+"");
				}else if(str.equals("city")){
					user.setCity(Integer.parseInt(map.get("city")+""));
				}else if(str.equals("salary")){
					user.setSalary((double)map.get("salary"));
				}else if(str.equals("starttime")){
					user.setStarttime(map.get("starttime")+"");
				}else if(str.equals("endtime")){
					user.setEndtime(map.get("endtime")+"");
				}else if(str.equals("description")){
					user.setDescription(map.get("description")+"");
				}
			}
			uList.add(user);
		}
		
		String res = JSONArray.fromObject(uList).toString();
		
		//打印
		System.out.println("res:"+res);
		return res;
	}

	@Override
	public String getUserListByPage(String pageSize,String pageCurrent) {
		UserDao userDao = new UserDaoImpl();
		List<Map<String, Object>> userList = userDao.getUserListByPage(pageSize, pageCurrent);
		//List<Map<String, Object>> userList = userDao.getUserList();
		List<User> uList = new ArrayList<User>();
		for(Map<String,Object> map : userList){
			Set<String> keySet = map.keySet();
			User user = new User();
			for(String str :keySet ){
				if(str.equals("id")){
					user.setId(Integer.parseInt(map.get("id")+""));
				}else if(str.equals("username")){
					user.setUsername(map.get("username")+"");
				}else if(str.equals("age")){
					user.setAge(Integer.parseInt(map.get("age")+""));
				}else if(str.equals("sex")){
					user.setSex(Integer.parseInt(map.get("sex")+""));;
				}else if(str.equals("birthday")){
					user.setBirthday(map.get("birthday")+"");
				}else if(str.equals("city")){
					user.setCity(Integer.parseInt(map.get("city")+""));
				}else if(str.equals("salary")){
					user.setSalary((double)map.get("salary"));
				}else if(str.equals("starttime")){
					user.setStarttime(map.get("starttime")+"");
				}else if(str.equals("endtime")){
					user.setEndtime(map.get("endtime")+"");
				}else if(str.equals("description")){
					user.setDescription(map.get("description")+"");
				}
			}
			uList.add(user);
		}
		int total = userDao.getTotal();
		int pagesize = Integer.parseInt(pageSize);
		int totalPage = total/pagesize == 0 ? total/pagesize : (total/pagesize)+1;
		String res = JSONArray.fromObject(uList).toString();
		//"totalRow":1000,"pageNumber":1,"firstPage":true,"lastPage":false,"totalPage":34,"pageSize":30,"list":
		String json = "{\"totalRow\":"+total+" ,\"pageNumber\":"+pageCurrent+",\"firstPage\":true,\"lastPage\":false,\"totalPage\":"+totalPage+",\"pageSize\":"+pagesize+", \"list\":"+res+"}";
		//打印
		System.out.println("json:"+json);
		return json;
	}
	
	@Override
	public int addSave(String username, String age, String sex, String birthday, String city, String salary,
			String starttime, String endtime, String description) throws Exception{
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.addSave(username, age, sex, birthday, city, salary, starttime, endtime, description);
	}

	@Override
	public int editSave(String id, String username, String age, String sex, String birthday, String city,
			String salary, String starttime, String endtime, String description) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		return userDao.editSave(id,username, age, sex, birthday, city, salary, starttime, endtime, description);
	}

	

}
