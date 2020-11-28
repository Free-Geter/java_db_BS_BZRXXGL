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

	//下面是Action内用于封装用户请求参数的属性
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
		
		//查询TC记录是否存在
		List<TCBean> list=new TCDao().GetList("TC_TeacherID='"+TC_TeacherID+"' and TC_ClassID="+TC_ClassID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该班主任已经在管理本班级了，不要重复添加！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//添加
		TCBean cnbean=new TCBean();
		cnbean.setTC_TeacherID(Integer.parseInt(TC_TeacherID));
		cnbean.setTC_ClassID(Integer.parseInt(TC_ClassID));

		new TCDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='TCManager.action?Class_ID="+TC_ClassID+"';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
