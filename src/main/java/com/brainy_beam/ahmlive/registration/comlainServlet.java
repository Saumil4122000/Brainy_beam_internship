package com.brainy_beam.ahmlive.registration;
import com.brainy_beam.ahmlive.db.*;
import com.brainy_beam.ahmlive.entity.Complain;
import com.brainy_beam.ahmlive.entity.User;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class comlain
 */
@WebServlet("/comlainServlet")
public class comlainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DELETE_ACTION = "delete";
	private static final String UPDATE_ACTION = "update";
    /**
     * Default constructor. 
     */
    public comlainServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.print(id);
		String action=request.getParameter("action");
		
		
		switch(action) {
		
		case UPDATE_ACTION:
		if(id>0) {
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("userData");
			try {
				Complain complain = new ComplainManagement().getComplainById(id,user.getId());
				request.setAttribute("complain", complain);
				System.out.print("Updated successfully");
				RequestDispatcher dispacher = request.getRequestDispatcher("/updateModalContent.jsp");
				dispacher.include(request, response);
				return;
			} catch (Exception  e) {
				System.out.println(user.getEmail());
				e.printStackTrace();
				request.setAttribute("error", "Something Went Wrong ! Please Try Again");
				RequestDispatcher dispacher = request.getRequestDispatcher("/updateModalContent.jsp");
				dispacher.include(request, response);
				return;
			}
		}
		else {
			request.setAttribute("error", "Something Went Wrong ! Please Try Again");
			RequestDispatcher dispacher = request.getRequestDispatcher("/updateModalContent.jsp");
			dispacher.include(request, response);
			return;
		}
	
			
		
		case DELETE_ACTION: if(id>0) {
							try {
								boolean isSuccess=new ComplainManagement().removeComplainById(id);
								System.out.print("Deleted Successfully");
								if(isSuccess) {
									
									request.getRequestDispatcher("complain.jsp").forward(request, response);
								}
								else {
									response.sendRedirect(request.getContextPath()+"/error.jsp");
								}
							}
							catch(Exception e){
								e.printStackTrace();
								response.sendRedirect(request.getContextPath()+"/error.jsp");
							}
						}
		default:
			request.setAttribute("error", "Something Went Wrong ! Please Try Again");
			RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
			dispacher.include(request, response);
			return;
				
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Complain complain = new Complain();
		String title = request.getParameter("title");
		complain.setTitle(title);
		String description = request.getParameter("description");
		complain.setDescription(description);
		String phoneNo = request.getParameter("phoneNo");
		complain.setMobileNo(phoneNo);
		String address = request.getParameter("address");
		complain.setAddress(address);
		if(title.trim().equals("")) {
			request.setAttribute("error", "Title should Not Be empty !");
			RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
			dispacher.include(request, response);
			return;
		}
		if(description.trim().equals("")) {
			request.setAttribute("error", "Discription should Not Be empty !");
			RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
			dispacher.include(request, response);
			return;
		}
		if(phoneNo.trim().equals("")) {
			request.setAttribute("error", "Mobile Number should Not Be empty !");
			RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
			dispacher.include(request, response);
			return;
		}
		if(address.trim().equals("")) {
			request.setAttribute("error", "Address should Not Be empty !");
			RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
			dispacher.include(request, response);
			return;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userData");
		if(user!=null) {
			complain.setUserId(user.getId());
			try {
				boolean isSuccess  = false;
				if(request.getParameter("id")!=null) {
					complain.setId(Integer.parseInt(request.getParameter("id")));
					isSuccess = new ComplainManagement().updateComplain(complain);
					if(isSuccess) {
						request.setAttribute("success", "Complain Updated Successfully !");
						RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
						dispacher.include(request, response);
						return;
					}
				}else {
					isSuccess =  new ComplainManagement().saveComplain(complain);
					if(isSuccess) {
						request.setAttribute("success", "Complain Added Successfully !");
						RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
						dispacher.include(request, response);
						return;
					}
				}
				if(!isSuccess){
					request.setAttribute("error", "Something went wrong !");
					RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
					dispacher.include(request, response);
					return;
				}
			} catch (Exception  e) {
				e.printStackTrace();
				request.setAttribute("error", "Something went wrong !");
				RequestDispatcher dispacher = request.getRequestDispatcher("/complain.jsp");
				dispacher.include(request, response);
				return;
			}
		}else {
			request.setAttribute("error", "Something Went Wrong!");
			RequestDispatcher dispacher = request.getRequestDispatcher("/login.jsp");
			dispacher.forward(request, response);
			return;
		}
	}

}
