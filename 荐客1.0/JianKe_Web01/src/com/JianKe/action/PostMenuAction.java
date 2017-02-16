package com.JianKe.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.JianKe.biz.MenuBiz;
import com.JianKe.pojo.Menu;
import com.JianKe.pojo.Menu_Category;
import com.JianKe.pojo.User;
import com.opensymphony.xwork2.ActionContext;

public class PostMenuAction {
	private List<File> pstimg ;
	private List<String> pstimgContentType ;
	private List<String> pstimgFileName ;
	private String mtitle;//标题
	private String mintroduce;//菜谱背景简介
	private String zhuliao1;// 主料
	private String zhuliao2; //主料
	private String fuliao1;//辅料
	private String fuliao2;//辅料
	private String fuliao3;//辅料
	private String step1; //步骤一
	private String step2; //步骤二
	private String step3; //步骤三
	private String step4;//步骤四
	private String step5;
	private String step6;
	private MenuBiz menuBiz;

	public List<File> getPstimg() {
		return pstimg;
	}
	public void setPstimg(List<File> pstimg) {
		this.pstimg = pstimg;
	}
	public List<String> getPstimgContentType() {
		return pstimgContentType;
	}
	public void setPstimgContentType(List<String> pstimgContentType) {
		this.pstimgContentType = pstimgContentType;
	}
	public List<String> getPstimgFileName() {
		return pstimgFileName;
	}
	public void setPstimgFileName(List<String> pstimgFileName) {
		this.pstimgFileName = pstimgFileName;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMintroduce() {
		return mintroduce;
	}
	public void setMintroduce(String mintroduce) {
		this.mintroduce = mintroduce;
	}
	public String getZhuliao1() {
		return zhuliao1;
	}
	public void setZhuliao1(String zhuliao1) {
		this.zhuliao1 = zhuliao1;
	}
	public String getZhuliao2() {
		return zhuliao2;
	}
	public void setZhuliao2(String zhuliao2) {
		this.zhuliao2 = zhuliao2;
	}
	public String getFuliao1() {
		return fuliao1;
	}
	public void setFuliao1(String fuliao1) {
		this.fuliao1 = fuliao1;
	}
	public String getFuliao2() {
		return fuliao2;
	}
	public void setFuliao2(String fuliao2) {
		this.fuliao2 = fuliao2;
	}
	public String getFuliao3() {
		return fuliao3;
	}
	public void setFuliao3(String fuliao3) {
		this.fuliao3 = fuliao3;
	}
	public String getStep1() {
		return step1;
	}
	public void setStep1(String step1) {
		this.step1 = step1;
	}
	public String getStep2() {
		return step2;
	}
	public void setStep2(String step2) {
		this.step2 = step2;
	}
	public String getStep3() {
		return step3;
	}
	public void setStep3(String step3) {
		this.step3 = step3;
	}
	public String getStep4() {
		return step4;
	}
	public void setStep4(String step4) {
		this.step4 = step4;
	}
	public String getStep5() {
		return step5;
	}
	public void setStep5(String step5) {
		this.step5 = step5;
	}
	public String getStep6() {
		return step6;
	}
	public void setStep6(String step6) {
		this.step6 = step6;
	}
	public void setMenuBiz(MenuBiz menuBiz) {
		this.menuBiz = menuBiz;
	}
	
	public String postmenulog(){
		User currUser = (User)ActionContext.getContext().getSession().get("CurrentUser");
		if(currUser == null && !"".equals(currUser)){
			ActionContext.getContext().getSession().put("islogin",1);
			return "fail";
		}else{
			return "success";
		}
	}
		
	public String execute() throws IOException{
		
			String[] imgs = new String[7];
			String realPath = ServletActionContext.getServletContext().getRealPath("/");
			String chilepath =  getChildPath(realPath);//创建一个子目录
			StringBuffer stringBuffersc = new StringBuffer(zhuliao1);
			stringBuffersc.append(",").append(zhuliao2).append(",").append(fuliao1).append(",").append(fuliao2).append(",").append(fuliao3);
			String strsc = stringBuffersc.toString();
			System.out.println("食材 ："+stringBuffersc);
			for(int i = 0 ; i < pstimg.size() ; i++ ){  
				String path = realPath+chilepath;
				String dbpath = chilepath+"/"+pstimgFileName.get(i);
				imgs[i] = dbpath;
				System.out.println("dbpath:"+dbpath);
				File storeDirtory = new File(path);
				if(!storeDirtory.exists()){
					storeDirtory.mkdirs();
				}	
				OutputStream os = new FileOutputStream(new File(path,pstimgFileName.get(i)));  
				InputStream is = new FileInputStream(pstimg.get(i));  
				byte[] buf = new byte[1024];  
				int length = 0 ;  
				while(-1 != (length = is.read(buf) ) ){  
					os.write(buf, 0, length) ;  
				}  
				is.close();  
				os.close();  
			} 
			
			//添加菜谱到数据库
			Menu menu = new Menu(mtitle,mintroduce,strsc,step1,imgs[1],step2,imgs[2],step3,imgs[3],step4,imgs[4],step5,imgs[5],step6,imgs[6],"","","","","","","",imgs[0],new Menu_Category(1),new User(1));
			menuBiz.addMenu(menu);
			
			return "success" ;
		
	}
	//检索子目录是否存在，如果不存在则创建。
	private String getChildPath(String realPath) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String timenow = df.format(date);
		
		File file = new File(realPath,timenow);
		if(file.exists()){
			file.mkdirs();
		}
		return timenow;
	}
}
