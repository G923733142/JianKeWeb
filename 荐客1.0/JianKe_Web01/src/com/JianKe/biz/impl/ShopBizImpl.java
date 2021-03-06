package com.JianKe.biz.impl;

import java.util.List;

import com.JianKe.biz.ShopBiz;
import com.JianKe.dao.CityDAO;
import com.JianKe.dao.ShopDAO;
import com.JianKe.pojo.PageBean;
import com.JianKe.pojo.Shop;

public class ShopBizImpl implements ShopBiz{
	private ShopDAO shopDAO = null;
	private CityDAO cityDAO = null;
	
	
	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}

	public void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}

	public List<Shop> getAllShops() {
		return shopDAO.getAll();
	}

	//根据城市获得该城市下的店铺
	public List<Shop> getShops(int cid) {
		return shopDAO.getshopList(cid);
	}

	public void delShop(int sid) {
		shopDAO.del(shopDAO.get(sid));
	}

	public void addShop(Shop shop) {
		shopDAO.save(shop);
	}

    //通过店铺自己的id来获得店铺，用作首页推荐
	public Shop getRemommendShops(int sid) {
		Shop shop = shopDAO.get(sid);
		return shop;
	}
	
	//分页查询 所有店铺
	public PageBean queryForPage(int pageSize, int page) {
		final String hql = "from Shop shop order by shop.sid";
		int allRow = shopDAO.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = shopDAO.queryForPage(hql, offset, length);
		
		//将分页信息保存到bean中 
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

	//分页查询 按城市搜索
	public PageBean queryForPageByCity(int pageSize, int page , int cityId) {
		final String hql = "from Shop where cid = '"+cityId+"'";
		int allRow = shopDAO.getAllRowCount(hql);//总记录数
		int totalPage = PageBean.countTatalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);//当前页开始记录
		final int length = pageSize;//每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		List list = shopDAO.queryForPage(hql, offset, length);
		
		//将分页信息保存到bean中 
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	public void upadteShop(Shop shop) {
		shopDAO.update(shop);
	}

	public List<Shop> getshopByrecommend(int isrecommend) {
		return shopDAO.getIndexShop(isrecommend);
	}

	public Shop getShop(int sid) {
		return shopDAO.get(sid);
	}


}
