package com.purplesoft.dao.impl;

import java.util.List;
import java.util.Map;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.basedao.impl.BaseDaoImp;
import com.purplesoft.dao.SjzbDao;
import com.purplesoft.pojo.SjzbTree;

public class SjzbDaoImpl implements SjzbDao {

	@Override
	public List<Map<String, Object>> getSjzbTree() {
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select * from sjzbtree where isParent = 'true' and pid = 0";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		return treeList;
	}

	@Override
	public List<Map<String, Object>> getRootNode(int pid) {
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select * from sjzbtree where pid = 0";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		return treeList;
	}

	@Override
	public List<Map<String, Object>> getChildren(String pid) {
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select * from sjzbtree where pid = "+pid+"";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		return treeList;
	}

	@Override
	public int getMaxTreeId() {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select Max(id) as c from sjzbtree";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		return Integer.parseInt(treeList.get(0).get("c")+"");
	}

	@Override
	public int addTree(String pid, String name, int id,String data) {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "insert into sjzbtree (id,pid,name,isParent,hidden,uri) value ("+id+","+pid+",'"+name+"','false','"+data+"','jsp/archives/sjzbdatagrid.jsp')";
		int n = baseDao.update(sql);
		return n;
	}

	@Override
	public String isParent(String pid) {
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select isParent from sjzbtree where id = "+pid+"";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		String isParent = treeList.get(0).get("isParent")+"";
		System.out.println("isParent:"+isParent);
		return isParent;
	}

	@Override
	public void updateParent(String pid) {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "update sjzbtree set isParent = 'true' where id = "+pid+"";
		baseDao.update(sql);
	}

	@Override
	public void reName(String id, String name) {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "update sjzbtree set name = '"+name+"' where id = "+id+"";
		baseDao.update(sql);
	}

	@Override
	public void delTree(String id) {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "delete from sjzbtree where id = "+id+"";
		baseDao.update(sql);
	}

	@Override
	public String getIdByPid(String id) {
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "select pid from sjzbtree where id = "+id+"";
		List<Map<String,Object>> treeList = baseDao.query(sql);
		String pid = treeList.get(0).get("pid")+"";
		return pid;
	}

	@Override
	public void updateParentToFalse(String pid) {
		// TODO Auto-generated method stub
		BaseDao<SjzbTree> baseDao = new BaseDaoImp<SjzbTree>();
		String sql = "update sjzbtree set isParent = 'false' where id = "+pid+"";
		baseDao.update(sql);
		
	}

	


}
