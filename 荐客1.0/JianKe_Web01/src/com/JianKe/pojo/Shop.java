package com.JianKe.pojo;

import java.util.Set;

public class Shop {
	private int sid;
	private String sname;
	private String address;
	private String tel;
	private String businesshour;
	private String introduce;
	private String image;
	private int eveprice;
	private int isrecommend;
	
	private City city;

	private Set<Challenge> challenges;
	private Set<Evaluate> evaluates;
	//private Set<Privilege> privileges;
	private Set<Goods> goods;
	
	public Shop(){}
	
	public Shop(int sid) {
		super();
		this.sid = sid;
	}

	public Shop(int sid, String sname, String address, String tel, String businesshour, String introduce, String image,
			int eveprice, int isrecommend, City city) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.tel = tel;
		this.businesshour = businesshour;
		this.introduce = introduce;
		this.image = image;
		this.eveprice = eveprice;
		this.isrecommend = isrecommend;
		this.city = city;
	}



	public Shop(String sname, String address, String tel, String businesshour, String introduce, String image,
			int eveprice, int isrecommend, City city) {
		super();
		this.sname = sname;
		this.address = address;
		this.tel = tel;
		this.businesshour = businesshour;
		this.introduce = introduce;
		this.image = image;
		this.eveprice = eveprice;
		this.isrecommend = isrecommend;
		this.city = city;
	}

	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}
	
	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public Set<Goods> getGoods() {
		return goods;
	}


	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}


	/*public Set<Privilege> getPrivileges() {
		return privileges;
	}


	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}*/

	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	
	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getBusinesshour() {
		return businesshour;
	}


	public void setBusinesshour(String businesshour) {
		this.businesshour = businesshour;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public Set<Challenge> getChallenges() {
		return challenges;
	}


	public void setChallenges(Set<Challenge> challenges) {
		this.challenges = challenges;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getEveprice() {
		return eveprice;
	}

	public void setEveprice(int eveprice) {
		this.eveprice = eveprice;
	}

	public int getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(int isrecommend) {
		this.isrecommend = isrecommend;
	}

	
	
}
