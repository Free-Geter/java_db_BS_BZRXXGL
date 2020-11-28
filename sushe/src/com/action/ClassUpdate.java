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

	//������Action�����ڷ�װ�û��������������
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

	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//��ѯ
		cnbean=new ClassDao().GetBean(Class_ID);
		list = new TeacherDao().GetList("", "");
		
		return SUCCESS;
		
		
	}
	
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}

	


	
	
}
