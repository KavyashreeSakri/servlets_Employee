package servlets_employee.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets_employee.dao.EmployeeDao;
import servlets_employee.dto.Employee;



public class EmployeeController extends HttpServlet{
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int id= Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			String address=req.getParameter("address");
			String email=req.getParameter("email");
			String password= req.getParameter("pwd");
			long phone=Long.parseLong(req.getParameter("phone"));
			
			Employee employee= new Employee();
			employee.setEmp_id(id);
			employee.setName(name);
			employee.setAddress(address);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setPhone(phone);
			
			EmployeeDao dao=new EmployeeDao();
			
			PrintWriter printWriter= resp.getWriter();
//			dao.saveEmployee(employee);
			
//			printWriter.print("Successfully saved employee");
	

			
			dao.updateEmployee(id, employee);
			printWriter.print("Successfully updated employee");
			
			
		
		}
	}


