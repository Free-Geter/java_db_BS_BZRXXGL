package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;
import com.mysql.cj.Session;


public class StudentLog extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private List<LogBean> list;
	private StudentBean cnBean;
	private int Student_ID;
	public List<LogBean> getList() {
		return list;
	}
	public void setList(List<LogBean> list) {
		this.list = list;
	}
	public StudentBean getCnBean() {
		return cnBean;
	}
	public void setCnBean(StudentBean cnBean) {
		this.cnBean = cnBean;
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
		list=new LogDao().GetList("Student_ID="+session.getAttribute("id"),"Log_Date desc");
		
	
		String strWhere="Student_ID="+session.getAttribute("id");
		//��ѯ����
		cnBean=new StudentDao().GetAllFirstBean(strWhere);
		Student_ID = cnBean.getStudent_ID();
		
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
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	
	
}
