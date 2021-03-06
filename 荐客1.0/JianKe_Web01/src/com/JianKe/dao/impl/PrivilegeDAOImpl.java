package com.JianKe.dao.impl;

import java.util.List;

import com.JianKe.dao.PrivilegeDAO;
import com.JianKe.dao.base.BaseDAOImpl;
import com.JianKe.pojo.Privilege;

public class PrivilegeDAOImpl extends BaseDAOImpl<Privilege> implements PrivilegeDAO {

	public List<Privilege> getList(int type) {
		String hql="from Privilege where type=?";
		List<Privilege> privileges=getHibernateTemplate().find(hql,type);
		return privileges;
	}

		
	public List<Privilege> getIndexList(int isrecommend) {
		String hql = "from Privilege where isrecommend = ?";
		List<Privilege> privilegeList = getHibernateTemplate().find(hql, isrecommend);		
		return privilegeList;
	}
	
	
	
}
