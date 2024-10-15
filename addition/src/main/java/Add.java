//9 october addition prgm 

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.PrintServiceAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNumber =request.getParameter("firstNumber"); //http transmit data in the form of text so its necessary to mention string 
		String secondNumber =request.getParameter("secondNumber"); //getparameter returntype is string
		
		int firstNumber1 = Integer.parseInt(firstNumber);
		int secondNumber2 = Integer.parseInt(secondNumber);
		
		int result =  firstNumber1 + secondNumber2;
		
		PrintWriter out = response.getWriter();
		out.println("the added value is"+result);
		
		
	}
   

}
