package com.bean;
public class TCBean {

    private int TC_ID ;
    private int TC_TeacherID ;
    private int TC_ClassID ;
    private String Class_Name ;
	
	public int getTC_ID() {
		return TC_ID;
	}
	public void setTC_ID(int tC_ID) {
		TC_ID = tC_ID;
	}
	public int getTC_TeacherID() {
		return TC_TeacherID;
	}
	public void setTC_TeacherID(int tC_TeacherID) {
		TC_TeacherID = tC_TeacherID;
	}
	public int getTC_ClassID() {
		return TC_ClassID;
	}
	public void setTC_ClassID(int tC_ClassID) {
		TC_ClassID = tC_ClassID;
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
	private String Teacher_Username ;
	public String getTeacher_Username() {
		return Teacher_Username;
	}
	public void setTeacher_Username(String teacherUsername) {
		Teacher_Username = teacherUsername;
	}
	
	public String getClass_Name() {
		return Class_Name;
	}
	public void setClass_Name(String class_Name) {
		Class_Name = class_Name;
	}
	
}
