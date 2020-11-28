package com.bean;
public class LogBean {

    private int Log_ID ;
    private int Log_StudentID ;
    private String Log_Date ;
    private String Log_Remark ;
	public int getLog_ID() {
		return Log_ID;
	}
	public void setLog_ID(int logID) {
		Log_ID = logID;
	}
	public int getLog_StudentID() {
		return Log_StudentID;
	}
	public void setLog_StudentID(int logStudentID) {
		Log_StudentID = logStudentID;
	}
	public String getLog_Date() {
		return Log_Date;
	}
	public void setLog_Date(String logDate) {
		Log_Date = logDate;
	}
	public String getLog_Remark() {
		return Log_Remark;
	}
	public void setLog_Remark(String logRemark) {
		Log_Remark = logRemark;
	}
    private String Teacher_Name ;
    private String Teacher_Sex ;
    private String Teacher_Tel ;
	public String getTeacher_Name() {
		return Teacher_Name;
	}
	public void setTeacher_Name(String teacherName) {
		Teacher_Name = teacherName;
	}
	public String getTeacher_Sex() {
		return Teacher_Sex;
	}
	public void setTeacher_Sex(String teacherSex) {
		Teacher_Sex = teacherSex;
	}
	public String getTeacher_Tel() {
		return Teacher_Tel;
	}
	public void setTeacher_Tel(String teacherTel) {
		Teacher_Tel = teacherTel;
	}
	
	private String Student_Username ;
    private String Student_Name ;
    private String Student_Sex ;
	public String getStudent_Username() {
		return Student_Username;
	}
	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String studentName) {
		Student_Name = studentName;
	}
	public String getStudent_Sex() {
		return Student_Sex;
	}
	public void setStudent_Sex(String studentSex) {
		Student_Sex = studentSex;
	}
	
	private String Domitory_Name ;
	private String Building_Name ;
	public String getDomitory_Name() {
		return Domitory_Name;
	}
	public void setDomitory_Name(String domitoryName) {
		Domitory_Name = domitoryName;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String buildingName) {
		Building_Name = buildingName;
	}
	
	private int Student_ClassID;
	private String Student_ClassName;
	public String getStudent_ClassName() {
		return Student_ClassName;
	}
	public void setStudent_ClassName(String student_ClassName) {
		this.Student_ClassName = student_ClassName;
	}
	public int getStudent_ClassID() {
		return Student_ClassID;
	}
	public void setStudent_ClassID(int student_ClassID) {
		Student_ClassID = student_ClassID;
	}
}
