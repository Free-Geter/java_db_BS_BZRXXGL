package com.db;

import java.sql.*;

public class DBHelper {	
	private String dbUrl="jdbc:mysql://localhost:3306/BZRXXGL";
	private String dbUser="root";
	private String dbPassword="200046m..";
	private String jdbcName="com.mysql.cj.jdbc.Driver";
	
	//连接数据库
	public Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){
			System.err.println("数据库连接失败");
		}
		return conn;		
	}
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DBHelper().getConn());
		
	}
	
}
