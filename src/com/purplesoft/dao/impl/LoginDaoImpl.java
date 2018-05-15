package com.purplesoft.dao.impl;

import java.util.List;
import java.util.Map;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.basedao.impl.BaseDaoImp;
import com.purplesoft.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {

	@Override
	public List<Map<String, Object>> Login(String username) {
		// TODO Auto-generated method stub
		BaseDao baseDao = new BaseDaoImp();
		String sql = "select * from user where username = '"+username+"'";
		List<Map<String ,Object>> list = baseDao.query(sql);
		return list;
	}

}
