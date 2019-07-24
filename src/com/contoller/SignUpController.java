package com.contoller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.SubmitUserDAO;
import com.modals.SubmitUser;
import com.service.SubmitToDb;
import com.utils.ValidateData;


@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	SubmitToDb db = null;
    public SignUpController() throws ClassNotFoundException, SQLException {
        super();
        db = new SubmitToDb(new SubmitUserDAO());
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		PrintWriter out = response.getWriter();
		String fromPageUser = request.getParameter("username");
		String fromPagepassword = request.getParameter("password");
		if(!ValidateData.isValidate(fromPageUser,fromPagepassword)) {
			dispatcher = request.getRequestDispatcher("/JSP/TEST.jsp");
			request.setAttribute("ErrorMessage",ValidateData.erMsg);
			}
		else {
			
			SubmitUser submitUser = new SubmitUser();
			submitUser.setUser(fromPageUser);
			submitUser.setPassword(fromPagepassword);
			try {
				if(!db.register(submitUser)) {
					out.println("Some Internal occured");
				}
				else {
					out.println("Registered Successfully");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		 dispatcher.forward(request, response);
	}
}
