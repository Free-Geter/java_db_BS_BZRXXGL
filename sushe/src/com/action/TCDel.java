package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TCDel extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String TC_ID ;
	private String TC_ClassID ;
	

	public String getTC_ID() {
		return TC_ID;
	}

	public void setTC_ID(String tC_ID) {
		TC_ID = tC_ID;
	}

	public String getTC_ClassID() {
		return TC_ClassID;
	}

	public void setTC_ClassID(String tC_ClassID) {
		TC_ClassID = tC_ClassID;
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
		
		
		//ɾ��
		new TCDao().Delete("TC_ID="+TC_ID);
		out.print("<script language='javascript'>window.location='TBManager.action?Class_ID="+TC_ClassID+"';</script>");
		out.flush();out.close();return null;
		
		
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
