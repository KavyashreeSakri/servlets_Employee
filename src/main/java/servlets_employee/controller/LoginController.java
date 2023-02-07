package servlets_employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_employee.dao.EmployeeDao;
import servlets_employee.dto.Employee;

public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter= resp.getWriter();
		int id=Integer.parseInt(req.getParameter("emp_id"));
		String email= req.getParameter("email");
		String password= req.getParameter("pwd");
		
//		Employee employee= new Employee();
		
		EmployeeDao dao= new EmployeeDao();
		Employee employee2= dao.LoginEmployee(id);
		if( email.equals(employee2.getEmail()) && password.equals(employee2.getPassword())) {
//			printWriter.print("Successfully logged in");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("SuccessLogin.html");
//			dispatcher.forward(req, resp);
			
			resp.sendRedirect("https://www.google.com/");
			
		}
		else {
//			printWriter.print("Invalid password and email");
			RequestDispatcher dispatcher=req.getRequestDispatcher("EmpLogin.html");
			dispatcher.forward(req, resp);
		}
	}

}
