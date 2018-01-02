package com.purplesoft.service;

public interface UserService {

	String getUserList();
	String getUserListByPage(String pageSize,String pageCurrent);
	int addSave(String username, String age, String sex, String birthday,
			String city, String salary,String starttime, String endtime, String description)throws Exception;
	
	int editSave(String id , String username, String age, String sex, String birthday,
			String city, String salary,String starttime, String endtime, String description)throws Exception;
}
