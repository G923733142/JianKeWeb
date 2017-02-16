package com.JianKe.dao;

import java.util.List;

import com.JianKe.dao.base.BaseDAO;
import com.JianKe.pojo.Menu;

public interface MenuDAO extends BaseDAO<Menu>{
	
		
		/**
		 * 分页查询
		 * @param hql 查询条件
		 * @param offset 开始记录
		 * @param length 一次查询几条
		 * @return 查询的记录集合
		 */
		public List<Menu> queryForPage(final String hql,final int offset,final int length);
		
		/**
		 * 查询所有记录
		 * @param hql 查询条件
		 * @return 总记录数
		 */
		public int getAllRowCount(String hql);
		
		
		/*模糊查询*/
		public List<Menu> getMenuByName(String mname);
	
		List<Menu> getListbycid(int menu_cid);
}
