package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class MyStudent extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<TBBean> list;
	private List<TCBean> list2;
	public List<TBBean> getList() {
		return list;
	}

	public void setList(List<TBBean> list) {
		this.list = list;
	}
	
	public List<TCBean> getList2() {
		return list2;
	}

	public void setList2(List<TCBean> list2) {
		this.list2 = list2;
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

		
		//��ѯ����
		list=new TBDao().GetList("TB_TeacherID="+session.getAttribute("id"),"Building_Name");
		list2=new TCDao().GetList("TC_TeacherID="+session.getAttribute("id"), "Class_Name");
		return SUCCESS;
		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}

	
	
}
