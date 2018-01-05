package com.purplesoft.basedao;

import java.util.List;
import java.util.Map;


public interface BaseDao<Entity> {
/**
 * 
* @Description:增删改基础实现
* @Author PurpleSoft
* @DateTime 2017年12月28日 上午10:01:00
* @param     参数
* @return    返回类型
 */
public int update(String sql);
/**
 * 
* @Description:查询方法
* @Author PurpleSoft
* @DateTime 2017年12月28日 上午10:01:34
* @param     参数
* @return    返回类型
 */
public List<Map<String,Object>> query(String sql);
	
}
