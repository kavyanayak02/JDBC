package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Student;
import com.qn.model.student;


public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int m1 = Integer.parseInt(request.getParameter("m1"));  
		int m2 = Integer.parseInt(request.getParameter("m2"));
		int m3 = Integer.parseInt(request.getParameter("m3"));
		Student tempStudent = new Student();
		tempStudent.setId(id);
		tempStudent.setName(name);
		tempStudent.setM1(m1);
		tempStudent.setM2(m2);
		tempStudent.setM3(m3);
		int rows = tempStudent.addResult();
		if(rows == 1) {
			response.sendRedirect("/add-result-mvc/addResultSuccess.html");
		}
		else {
			response.sendRedirect("/add-result-mvc/addResultFailure.html");
		}
			
		
	}

}
