package com.brainy_beam.ahmlive.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.brainy_beam.ahmlive.db.UserManager;
import com.brainy_beam.ahmlive.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

  
    public LoginServlet() {
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			User user=new UserManager().getUserByEmail(email);
			if(user.getPassword().equals(password)) {
				
				HttpSession session=request.getSession();
				session.setAttribute("userData", user);
				
				Cookie cookie=new Cookie("lastName",user.getLname());
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("error", "Invalid email or password");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
