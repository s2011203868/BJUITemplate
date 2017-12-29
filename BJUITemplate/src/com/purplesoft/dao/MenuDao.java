package com.purplesoft.dao;

import java.util.List;
import java.util.Map;

public interface MenuDao {

	List<Map<String, Object>>getMenuListByZid(int zid);

	int getpidMax(int zid);

	String [] getPname(int zid);

	String getChildren(String string);
}
