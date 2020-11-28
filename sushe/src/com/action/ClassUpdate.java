package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ClassUpdate extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private int  Class_ID;
	private ClassBean cnbean;
	private List<TeacherBean> list;

	public List<TeacherBean> getList() {
		return list;
	}

	public void setList(List<TeacherBean> list) {
		this.list = list;
	}


	public int getClass_ID() {
		return Class_ID;
	}

	public void setClass_ID(int class_ID) {
		Class_ID = class_ID;
	}

	public ClassBean getCnbean() {
		return cnbean;
	}

	public void setCnbean(ClassBean cnbean) {
		this.cnbean = cnbean;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询
		cnbean=new ClassDao().GetBean(Class_ID);
		list = new TeacherDao().GetList("", "");
		
		return SUCCESS;
		
		
	}
	
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}

	


	
	
}
