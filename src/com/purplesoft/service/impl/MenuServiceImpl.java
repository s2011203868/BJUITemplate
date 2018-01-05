package com.purplesoft.service.impl;

import com.purplesoft.dao.MenuDao;
import com.purplesoft.dao.impl.MenuDaoImpl;
import com.purplesoft.service.MenuService;

public class MenuServiceImpl implements MenuService {

	MenuDao menuDao = new MenuDaoImpl();
	@Override
	public String getMenuListByZid(int zid) {

		/*List<Map<String, Object>> MenuList = menuDao.getMenuListByZid(zid);
		List<MainMenu> list = new ArrayList<MainMenu>();
		int pidMax = menuDao.getpidMax(zid);*/
		String [] pname = menuDao.getPname(zid);
		StringBuffer sb = new StringBuffer("[");
		
		for(int i = 0 ;i<pname.length ;i++ ){
			String child = menuDao.getChildren(pname[i]);
			sb.append("{\"name\":").append("\""+pname[i]+"\"").append(",").append("\"children\":").append(""+child+"").append("},");
		}
		sb.deleteCharAt(sb.length() - 1).append("]");
		//打印
		System.out.println(sb.toString());
		return sb.toString();
	}

}
