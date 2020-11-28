package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TCAddSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String TC_TeacherID ;
    private String TC_ClassID ;
	
	public String getTC_TeacherID() {
		return TC_TeacherID;
	}

	public void setTC_TeacherID(String tC_TeacherID) {
		TC_TeacherID = tC_TeacherID;
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
		
		//��ѯTC��¼�Ƿ����
		List<TCBean> list=new TCDao().GetList("TC_TeacherID='"+TC_TeacherID+"' and TC_ClassID="+TC_ClassID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('�ð������Ѿ��ڹ����༶�ˣ���Ҫ�ظ���ӣ�');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//���
		TCBean cnbean=new TCBean();
		cnbean.setTC_TeacherID(Integer.parseInt(TC_TeacherID));
		cnbean.setTC_ClassID(Integer.parseInt(TC_ClassID));

		new TCDao().Add(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('��ӳɹ���');window.location='TCManager.action?Class_ID="+TC_ClassID+"';</script>");
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
