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

	//下面是Action内用于封装用户请求参数的属性
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
		
		//查询班级名是否存在
		List<ClassBean> list=new ClassDao().GetList("Class_Name='"+Class_Name+"' and Class_ID!="+Class_ID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('班级名已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//修改
		
		ClassBean cnbean=new ClassBean();
		cnbean=new ClassDao().GetBean(Class_ID);
		cnbean.setClass_Back(Class_Back);
		cnbean.setClass_Dept(Class_Dept);
		cnbean.setClass_Name(Class_Name);
		cnbean.setClass_Number(Class_Number);
		cnbean.setClass_Teacher(Class_Teacher);
		cnbean.setClass_Time(Class_Time);
		new ClassDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='ClassManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
