package com.JianKe.action;

import java.util.List;

import com.JianKe.biz.PrivilegeBiz;
import com.JianKe.biz.impl.PrivilegeBizImpl;
import com.JianKe.pojo.Privilege;
import com.opensymphony.xwork2.ActionContext;

public class PrivilegeAction {
	private PrivilegeBiz privilegeBiz;
	
	public PrivilegeBiz getPrivilegeBiz() {
		return privilegeBiz;
	}
	public void setPrivilegeBiz(PrivilegeBiz privilegeBiz) {
		this.privilegeBiz = privilegeBiz;
	}
	
	public String execute(){
		List<Privilege> privileges=privilegeBiz.getAll();
		ActionContext.getContext().getSession().put("privileges", privileges);
		return "success";
	}
}
