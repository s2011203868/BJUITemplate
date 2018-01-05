package com.purplesoft.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.basedao.impl.BaseDaoImp;
import com.purplesoft.dao.MenuDao;
import com.purplesoft.pojo.MainMenu;

import net.sf.json.JSONArray;

public class MenuDaoImpl implements MenuDao {

	BaseDao<MainMenu> BaseDao = new BaseDaoImp<MainMenu>();
	@Override
	public List<Map<String, Object>> getMenuListByZid(int zid) {
		String sql = "select * from mainmenu where zid="+zid+"";
		List<Map<String, Object>> menuList = BaseDao.query(sql);
		return menuList;
	}
	@Override
	public int getpidMax(int zid) {
		String sql = "SELECT COUNT(1) AS c FROM (SELECT *FROM mainmenu WHERE zid = "+zid+" GROUP BY pid ) temp"; 
		List<Map<String, Object>> pidList = BaseDao.query(sql);
		int count =Integer.parseInt(pidList.get(0).get("c")+"");
		return count;
	}
	@Override
	public String [] getPname(int zid) {
		String sql = "SELECT pname FROM mainmenu WHERE zid = "+zid+" GROUP BY pid "; 
		List<Map<String, Object>> pname = BaseDao.query(sql);
		String [] pnameStrings = new String [pname.size()];
		for(int i = 0 ;i<pname.size();i++){
			String pString = pname.get(i).get("pname")+"";
			pnameStrings[i] = pString;
		}
		return pnameStrings;
	}
	@Override
	public String getChildren(String pname) {
		String sql = "SELECT id,name,target,url FROM mainmenu WHERE pname='"+pname+"'";
		List<Map<String, Object>> childrenList = BaseDao.query(sql);
		List<MainMenu> menuList = new ArrayList<MainMenu>();
		for(Map<String, Object> map : childrenList){
			MainMenu mainMenu = new MainMenu();
			Set<String> keySet = map.keySet();
			for(String key : keySet ){
				if(key.equals("id")){
					mainMenu.setId(map.get(key)+"");
				}else if(key.equals("name")){
					mainMenu.setName(map.get(key)+"");
				}else if(key.equals("target")){
					mainMenu.setTarget(map.get(key)+"");
				}else if(key.equals("url")){
					mainMenu.setUrl(map.get(key)+"");
				}
			}
			menuList.add(mainMenu);
		}
		String re = JSONArray.fromObject(menuList).toString();
		return re;
	}
}
