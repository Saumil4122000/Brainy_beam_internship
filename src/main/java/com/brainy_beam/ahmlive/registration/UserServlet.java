package com.brainy_beam.ahmlive.registration;

import java.io.IOException;

import com.brainy_beam.ahmlive.entity.User;
import com.brainy_beam.ahmlive.db.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userData");
		if(user!=null) {
			User newUser = new User();
			if(request.getParameter("fname").trim().equals("")) {
				request.setAttribute("error", "firstname should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/profile.jsp");
				dispacher.include(request, response);
				return;
			}
			if(request.getParameter("lname").trim().equals("")) {
				request.setAttribute("error", "lastname should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
		
			if(request.getParameter("email").trim().equals("")) {
				request.setAttribute("error", "email should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
			if(request.getParameter("phoneNumber").trim().equals("")) {
				request.setAttribute("error", "mobile No. should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
		
			if(request.getParameter("password").trim().equals("")) {
				request.setAttribute("error", "Password should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
			
			if(request.getParameter("address").trim().equals("")) {
				request.setAttribute("error", "Password should Not Be empty !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
			
			newUser.setFname(request.getParameter("fname"));
			newUser.setLname(request.getParameter("lname"));
			
			newUser.setEmail(request.getParameter("email"));
			newUser.setPhoneNumber(request.getParameter("phoneNumber"));
			
			newUser.setAddress(request.getParameter("address"));
			newUser.setPassword(request.getParameter("password"));
			newUser.setId(user.getId());
			try {
				boolean isSuccess  = false;
					isSuccess =  new UserManager().updateUser(newUser);
					session.setAttribute("userData", newUser);
					if(isSuccess) {
						request.setAttribute("success", "Profile Updated Successfully !");
						RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
						dispacher.include(request, response);
						return;
					}else {
						request.setAttribute("error", "Something went wrong !");
						RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
						dispacher.include(request, response);
						return;
					}
			} catch (Exception  e) {
				e.printStackTrace();
				request.setAttribute("error", "Something went wrong !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/viewProfile.jsp");
				dispacher.include(request, response);
				return;
			}
		}else {
			request.setAttribute("error", "Something Went Wrong!");
			RequestDispatcher dispacher = request.getRequestDispatcher("/Login.jsp");
			dispacher.forward(request, response);
			return;
		}
	}

}
