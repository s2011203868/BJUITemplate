package com.purplesoft.basedao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.purplesoft.basedao.BaseDao;
import com.purplesoft.util.DbcpDataSource;


public class BaseDaoImp<Entity> implements BaseDao<Entity> {

	public int update(String sql){
		Connection conn = DbcpDataSource.getConnection();
		Statement stam =null;
		int n =0;
		try {
			stam = conn.createStatement();
			n = stam.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public List<Map<String, Object>> query(String sql) {
		Connection conn = DbcpDataSource.getConnection();
		Statement stam =null;
		ResultSet rest = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			stam = conn.createStatement();
			rest = stam.executeQuery(sql);
			while(rest.next()){
				Map<String,Object> map = new HashMap<String, Object>();
				ResultSetMetaData rstm = rest.getMetaData();
				int count = rstm.getColumnCount();
				for(int i = 1;i<=count;i++){
					String key = rstm.getColumnName(i);	
					Object value = rest.getObject(key);
					map.put(key, value);
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rest != null){
				try {
					rest.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stam != null){
				try {
					stam.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbcpDataSource.close(conn,rest,null,stam);
		}
		return list;
	}



}
