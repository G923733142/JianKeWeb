package com.JianKe.action;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.JianKe.biz.CommentBiz;
import com.JianKe.pojo.Challenge;
import com.JianKe.pojo.Comment;
import com.JianKe.pojo.User;
import com.opensymphony.xwork2.ActionContext;

public class commentAction {

private CommentBiz commentBiz;
private int chid;
private String content;

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public int getChid() {
	return chid;
}

public void setChid(int chid) {
	this.chid = chid;
}


public CommentBiz getCommentBiz() {
	return commentBiz;
}


public void setCommentBiz(CommentBiz commentBiz) {
	this.commentBiz = commentBiz;
}


public String addcomment(){
	System.out.println("content --- "+content);
	Map<String, Object> session = ActionContext.getContext().getSession();
	int userid =((User)session.get("CurrUser")).getUid();
	Date date = new Date();
	//Comment comment = new Comment(content,date,new Challenge(chid),new User(userid));
	//commentBiz.addComment(comment);
	return null;
}
	
	
}
