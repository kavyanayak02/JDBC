//add result into the table

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 
		// gives me the id in the string format 
				//we are converting id from string to integer by using pareseint()
				
				String name = request.getParameter("name");
				//name is required in the string format. therefore we are not converting it into an int 
				
				int m1 = Integer.parseInt(request.getParameter("m1"));  
				int m2 = Integer.parseInt(request.getParameter("m2"));
				int m3 = Integer.parseInt(request.getParameter("m3"));
				
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
		         int rows =pstmt.executeUpdate();
		         PrintWriter out = response.getWriter();
		         if(rows == 0) {
		        	 out.println("student data not added");
		         }
		         else {
		        	 out.println("student data added sucessfully");
		         }
		         
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		         
		
	}

}
