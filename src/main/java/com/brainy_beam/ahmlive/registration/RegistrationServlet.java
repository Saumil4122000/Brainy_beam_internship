package com.brainy_beam.ahmlive.registration;

import java.io.IOException;
import java.io.PrintWriter;

import com.brainy_beam.ahmlive.db.DatabaseConnectionUtil;
import com.brainy_beam.ahmlive.db.UserManager;
import com.brainy_beam.ahmlive.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RegistrationServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User userObj=new User();
		userObj.setFname(request.getParameter("fname"));
		userObj.setLname(request.getParameter("lname"));
		userObj.setPassword(request.getParameter("password"));
		userObj.setEmail(request.getParameter("email"));
		userObj.setAddress(request.getParameter("address"));
		userObj.setPhoneNumber(request.getParameter("phoneNumber"));
		
		
		if(userObj.getFname().trim().equals("")) {
			request.setAttribute("error","First name can't be empty ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		if(userObj.getLname().trim().equals("")) {
			request.setAttribute("error","Last name can't be empty");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		if(userObj.getEmail().trim().equals("")) {
			request.setAttribute("error","Email can't be empty ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		if(userObj.getPhoneNumber().trim().equals("")) {
			request.setAttribute("error","Phone Number can't be Empty ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		if(userObj.getPassword().trim().equals("")) {
//			request.setAttribute("error","Password  can't be empty ");
			System.out.print("Password can't be empty");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		if(userObj.getAddress().trim().equals("")) {
			request.setAttribute("error","Address can't be empty ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		try  {
			boolean issucess=new UserManager().registerUser(userObj);
			if(issucess) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
			else {
				PrintWriter out=response.getWriter();
				out.print("Invalid email and password");
				out.close();
				
				response.getWriter().append("Seomething went wrong ").append(request.getContextPath());
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Register.jsp");
				dispatcher.include(request, response);
			}
		} 
	
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	
	

}
