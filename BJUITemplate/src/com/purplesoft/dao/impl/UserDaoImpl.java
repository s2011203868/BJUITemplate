package com.purplesoft.dao.impl;

import java.util.List;
import java.util.Map;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.basedao.impl.BaseDaoImp;
import com.purplesoft.dao.UserDao;
import com.purplesoft.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<Map<String, Object>> getUserList() {
		BaseDao<User> baseDao = new BaseDaoImp<User>();
		List<Map<String, Object>> List = baseDao.query("select * from user");
		return List;
	}
	
	@Override
	public int getTotal() {
		BaseDao<User> baseDao = new BaseDaoImp<User>();
		List<Map<String, Object>> List = baseDao.query("select * from user");
		return List.size();
	}

	@Override
	public List<Map<String, Object>> getUserListByPage(String pageSize, String pageCurrent) {
		BaseDao<User> baseDao = new BaseDaoImp<User>();
		String sql = "SELECT * FROM USER LIMIT "+((Integer.parseInt(pageCurrent))-1)*(Integer.parseInt(pageCurrent))+","+pageSize+""; 
		List<Map<String, Object>> List = baseDao.query(sql);
		return List;
	}
	
	@Override
	public int addSave(String username, String age, String sex, String birthday, String city, String salary,
			String starttime, String endtime, String description) throws Exception{
		BaseDao<User> baseDao = new BaseDaoImp<User>();
		String sql = "INSERT INTO USER (username,age,sex,birthday,city,salary,starttime,endtime,description) VALUE ('"+username+"',"+age+","+sex+",'"+birthday+"','"+city+"',"+salary+",'"+starttime+"','"+endtime+"','"+description+"')"; 
		return baseDao.update(sql);
	}

	@Override
	public int editSave(String id, String username, String age, String sex, String birthday, String city,
			String salary, String starttime, String endtime, String description)throws Exception {
		// TODO Auto-generated method stub
		BaseDao<User> baseDao = new BaseDaoImp<User>();
		String sql = "UPDATE USER SET username = '"+username+"', age = "+age+" , sex = "+sex+" , birthday = '"+birthday+"' ,city = '"+city+"' , salary =  "+salary+" , starttime = '"+starttime+"' , endtime = '"+endtime+"' , description = '"+description+"' WHERE id = "+id+"";
		return baseDao.update(sql);
	}

	

	

}
