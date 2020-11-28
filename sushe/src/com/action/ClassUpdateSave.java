package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class ClassUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private int Class_ID ;
    private int Class_Teacher ;
    private String Class_Time ;
    private String Class_Dept ;
    private String Class_Name ;
    private String Class_Back ;
    private String Class_Number ;
    private String Class_TN;
    
    public int getClass_ID() {
		return Class_ID;
	}

	public void setClass_ID(int class_ID) {
		Class_ID = class_ID;
	}

	public int getClass_Teacher() {
		return Class_Teacher;
	}

	public void setClass_Teacher(int class_Teacher) {
		Class_Teacher = class_Teacher;
	}

	public String getClass_Time() {
		return Class_Time;
	}

	public void setClass_Time(String class_Time) {
		Class_Time = class_Time;
	}

	public String getClass_Dept() {
		return Class_Dept;
	}

	public void setClass_Dept(String class_Dept) {
		Class_Dept = class_Dept;
	}

	public String getClass_Name() {
		return Class_Name;
	}

	public void setClass_Name(String class_Name) {
		Class_Name = class_Name;
	}

	public String getClass_Back() {
		return Class_Back;
	}

	public void setClass_Back(String class_Back) {
		Class_Back = class_Back;
	}

	public String getClass_Number() {
		return Class_Number;
	}

	public void setClass_Number(String class_Number) {
		Class_Number = class_Number;
	}

	public String getClass_TN() {
		return Class_TN;
	}

	public void setClass_TN(String class_TN) {
		Class_TN = class_TN;
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
		
		//��ѯ�༶���Ƿ����
		List<ClassBean> list=new ClassDao().GetList("Class_Name='"+Class_Name+"' and Class_ID!="+Class_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�༶���Ѿ����ڣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//�޸�
		
		ClassBean cnbean=new ClassBean();
		cnbean=new ClassDao().GetBean(Class_ID);
		cnbean.setClass_Back(Class_Back);
		cnbean.setClass_Dept(Class_Dept);
		cnbean.setClass_Name(Class_Name);
		cnbean.setClass_Number(Class_Number);
		cnbean.setClass_Teacher(Class_Teacher);
		cnbean.setClass_Time(Class_Time);
		new ClassDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='ClassManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}
	
}