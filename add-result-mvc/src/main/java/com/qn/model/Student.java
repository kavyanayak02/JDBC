package com.qn.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//generate setter-getter, constructor,tostring,default constructor
public class Student extends HttpServlet {
	private int id;
	private String name;
	private int m1;
	private int m2;
	private int m3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getM1() {
		return m1;
	}
	public void setM1(int m1) {
		this.m1 = m1;
	}
	public Student(int id, String name, int m1, int m2, int m3) {
		super();
		this.id = id;
		this.name = name;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getM2() {
		return m2;
	}
	public void setM2(int m2) {
		this.m2 = m2;
	}
	public int getM3() {
		return m3;
	}
	public void setM3(int m3) {
		this.m3 = m3;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}
	
	// till here generating the methods
	
	
	public int addResult() {
		try {
			 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

	         String s = "insert into student values(?, ?, ?, ?, ?)";
	         PreparedStatement pstmt = con.prepareStatement(s);
	         pstmt.setInt(1, id);
	         pstmt.setString(2, name);
	         pstmt.setInt(3, m1);
	         pstmt.setInt(4, m2);
	         pstmt.setInt(5, m3);
	         int rows = pstmt.executeUpdate();
	         return rows;
	         
		}catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
	
	         
		}
	}


