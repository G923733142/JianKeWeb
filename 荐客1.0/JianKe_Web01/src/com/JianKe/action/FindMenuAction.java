package com.JianKe.action;

import java.util.List;

import com.JianKe.biz.MenuBiz;
import com.JianKe.pojo.Menu;
import com.opensymphony.xwork2.ActionContext;

public class FindMenuAction {
	
	private String mname;
	private MenuBiz menuBiz;

	public MenuBiz getMenuBiz() {
		return menuBiz;
	}
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
	
	public String findmenu(){
		List<Menu> menus = menuBiz.getMenuByName(mname);
		ActionContext.getContext().getSession().put("menulist", menus);
		return "success";
	}
}
