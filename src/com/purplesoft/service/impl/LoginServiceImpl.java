package com.purplesoft.service.impl;

import java.util.List;
import java.util.Map;

import com.purplesoft.dao.LoginDao;
import com.purplesoft.dao.impl.LoginDaoImpl;
import com.purplesoft.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public List login(String username) {
		LoginDao loginDao = new LoginDaoImpl();
		List<Map<String, Object>> list = loginDao.Login(username);
		return list;
	}

}
