package com.purplesoft.service;

public interface SjzbService {

	String getTree();
	String getTreeByPid(String pid);
	int addTree(String pid,String name);
}
