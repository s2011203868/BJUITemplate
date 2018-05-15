package com.purplesoft.dao;

import java.util.List;
import java.util.Map;

public interface LoginDao {

	List<Map<String,Object>> Login(String username);
}
