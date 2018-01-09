package com.purplesoft.dao;

import java.util.List;
import java.util.Map;

public interface SjzbDao {

	List<Map<String,Object>> getSjzbTree();

	List<Map<String, Object>> getRootNode(int pid);

	List<Map<String, Object>> getChildren(String pid);

	int getMaxTreeId();

	int addTree(String pid, String name, int id);

	String isParent(String pid);

	void updateParent(String pid);

	void reName(String id, String name);

	void delTree(String id);

	String getIdByPid(String id);

	void updateParentToFalse(String pid);

	

}
