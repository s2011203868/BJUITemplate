package com.purplesoft.service;

public interface SjzbService {

	String getTree();
	String getTreeByPid(String pid);
	int addTree(String pid,String name,String data);
	void reName(String id, String name);
	void delTree(String id);
}
