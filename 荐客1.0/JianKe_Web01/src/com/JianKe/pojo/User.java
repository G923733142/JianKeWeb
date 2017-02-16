package com.JianKe.pojo;

import java.util.Set;

public class User {
	private int uid;
	private String uname;
	private String pwd;
	private String mail;
	private String nickname;
	private String headicon;
	private Set<Challenge> challenges;
	private Set<User> friends;
	
	private Set<Menu> menus;
	private Set<Comment> comments;
	private Set<Evaluate> evaluates;
	private Set<Menu> cMenus;
	
	public User(){}

	public User(String uname, String pwd, String mail, String nickname) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.mail = mail;
		this.nickname = nickname;
	}

		
	
	public User(String uname, String pwd, String mail, String nickname, String headicon) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.mail = mail;
		this.nickname = nickname;
		this.headicon = headicon;
	}

	public User(int uid) {
		super();
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadicon() {
		return headicon;
	}

	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}

	public Set<Challenge> getChallenges() {
		return challenges;
	}

	public void setChallenges(Set<Challenge> challenges) {
		this.challenges = challenges;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Evaluate> getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(Set<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Set<Menu> getcMenus() {
		return cMenus;
	}

	public void setcMenus(Set<Menu> cMenus) {
		this.cMenus = cMenus;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", mail=" + mail + ", nickname=" + nickname
				+ ", headicon=" + headicon + "]";
	}

	
	
	
	
	
	
}
