package com.purplesoft.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.purplesoft.dao.SjzbDao;
import com.purplesoft.dao.impl.SjzbDaoImpl;
import com.purplesoft.service.SjzbService;

import net.sf.json.JSONArray;

public class SjzbServiceImpl implements SjzbService {

	@Override
	public String getTree() {
		// TODO Auto-generated method stub
		SjzbDao sjzbDao = new SjzbDaoImpl();
		List<Map<String,Object>> treeList = sjzbDao.getSjzbTree();
		String json = JSONArray.fromObject(treeList).toString();
		return json;
	}

	@Override
	public String getTreeByPid(String pid) {
		// TODO Auto-generated method stub
		SjzbDao sjzbDao = new SjzbDaoImpl();
		List<Map<String,Object>> treeList = sjzbDao.getChildren(pid);
		String json = JSONArray.fromObject(treeList).toString();
		return json;
	}

	@Override
	public int addTree(String pid,String name) {
		// TODO Auto-generated method stub
		SjzbDao sjzbDao = new SjzbDaoImpl();
		int MaxId = sjzbDao.getMaxTreeId();
		System.out.println(pid);
		int id = MaxId + 1;
		String isParent = sjzbDao.isParent(pid);
		if(isParent.equals("false")){
			sjzbDao.updateParent(pid);
		}
		int n = sjzbDao.addTree(pid,name,id);
		return n;
	}

}
