package com.dao;

import com.db.DBHelper;
import com.bean.ClassBean;
import com.bean.DomitoryBean;

import java.util.*;
import java.sql.*;

public class ClassDao {
	
	//获取列表
	public List<ClassBean> GetList(String strwhere,String strorder){
		String sql="select * from Class,Teacher where Class_Teacher=Teacher_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<ClassBean> list=new ArrayList<ClassBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				ClassBean cnbean=new ClassBean();
				cnbean.setClass_ID(rs.getInt("Class_ID"));
				cnbean.setClass_Teacher(rs.getInt("Class_Teacher"));
				cnbean.setClass_Name(rs.getString("Class_Name"));
				cnbean.setClass_Number(rs.getString("Class_Number"));
				cnbean.setClass_Time(rs.getString("Class_Time"));
				cnbean.setClass_Dept(rs.getString("Class_Dept"));
				cnbean.setClass_Back(rs.getString("Class_Back"));
				cnbean.setClass_TN(rs.getString("Teacher_Name"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取指定ID的实体Bean
	public ClassBean GetBean(int id){
		String sql="select * from Class,Teacher where Class_Teacher=Teacher_ID and Class_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		ClassBean cnbean=new ClassBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setClass_ID(rs.getInt("Class_ID"));
				cnbean.setClass_Teacher(rs.getInt("Class_Teacher"));
				cnbean.setClass_Name(rs.getString("Class_Name"));
				cnbean.setClass_Number(rs.getString("Class_Number"));
				cnbean.setClass_Time(rs.getString("Class_Time"));
				cnbean.setClass_Dept(rs.getString("Class_Dept"));
				cnbean.setClass_Back(rs.getString("Class_Back"));
				cnbean.setClass_TN(rs.getString("Teacher_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//添加
	public void Add(ClassBean cnbean){
		String sql="insert into Class (";
		sql+="Class_ID,Class_Teacher,Class_Time,Class_Dept,Class_Name,Class_Back,Class_Number";
		sql+=") values(";
		sql+="'"+cnbean.getClass_ID()+"','"+cnbean.getClass_Teacher()+"','"+cnbean.getClass_Time()+"','"+cnbean.getClass_Dept()+"','"
				+ cnbean.getClass_Name()+"','"+cnbean.getClass_Back()+"','"+cnbean.getClass_Number()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//修改
	public void Update(ClassBean cnbean){
		String sql="update Class set ";
		sql+="Class_Teacher='"+cnbean.getClass_Teacher()+"',";
		sql+="Class_Time='"+cnbean.getClass_Time()+"',";
		sql+="Class_Dept='"+cnbean.getClass_Dept()+"',";
		sql+="Class_Name='"+cnbean.getClass_Name()+"',";
		sql+="Class_Back='"+cnbean.getClass_Back()+"',";
		sql+="Class_Number='"+cnbean.getClass_Number()+"'";
		
		sql+=" where Class_ID='"+cnbean.getClass_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete from Class where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

