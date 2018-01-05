package com.purplesoft.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {

	List<Map<String,Object>> getUserList();
	
	List<Map<String, Object>> getUserListByPage(String pageSize,String pageCurrent);
	
	int addSave(String username, String age, String sex, String birthday,
			String city, String salary,String starttime, String endtime, String description) throws Exception;
	
	int editSave(String id,String username, String age, String sex, String birthday,
			String city, String salary,String starttime, String endtime, String description)throws Exception;

	int getTotal();
	
	int delUser(String s);
	
}
