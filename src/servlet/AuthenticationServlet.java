package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Usersdao;
import model.Users;
import url_patterns.URLPatterns;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet({"/AuthenticationServlet",
			URLPatterns.SUBMITCREATEUSERREQUEST})

public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pattern = request.getServletPath();
		
		switch (pattern) {
		case URLPatterns.SUBMITCREATEUSERREQUEST:
			tryCreateUserRequest(request, response);
		}
		
	}
	
	private void tryAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//get Input Data
		String ProductName = request.getParameter("productName");
        double ProductPrice = Double.parseDouble(request.getParameter("productPrice"));
        int Stock = Integer.parseInt(request.getParameter("availableStock"));
        int Threshold = Integer.parseInt(request.getParameter("threshold"));
        int Ceiling = Integer.parseInt(request.getParameter("ceiling"));
	}
	
	private void tryCreateUserRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Process type of request
		
		String actionToDo = request.getParameter("submitButton");
		
		System.out.println(actionToDo);
		
		if (actionToDo.equals("submitUserRequest")) {
			
			//Retrieve Session
			HttpSession session = request.getSession();
			
			//getInputData
			String firstName = request.getParameter("Firstname");
			String lastName = request.getParameter("Lastname");
			String oldUserName = request.getParameter("OldUsername");
			String userName = request.getParameter("Username");
			String oldPassword = request.getParameter("OldPassword");
			String password = request.getParameter("Password");
			String rePassword = request.getParameter("RePassword");
			String position = request.getParameter("Position");
			String address = request.getParameter("Address");
		
			Users u =Usersdao.getUserByUsername(oldUserName);
			
			System.out.println(u.getPassword() + " AND " + oldPassword);
			
			if (u != null) {
				if (u.getPassword().equals(oldPassword)) {
					if (password.equals(rePassword)) {
						Users updatedUser = new Users(firstName, lastName, userName, password, position, address);
						updatedUser.setUserId(u.getUserId());
						session.setAttribute("updatedUser", updatedUser);
						response.sendRedirect("/Six_Eagles/updateUser");
					} else {
						session.setAttribute("errorMessage", "Password and Confirm Password do not match!!!");
						response.sendRedirect("/Six_Eagles/createUser");
					}
				} else {
					session.setAttribute("errorMessage", "Old Password is incorrect!!!");
					response.sendRedirect("/Six_Eagles/createUser");
				}
			} else {
				session.setAttribute("errorMessage", "No Such User!!!");
				response.sendRedirect("/Six_Eagles/createUser");
			}
	
			
		} else if (actionToDo.equals("cancelUserRequest"))
			response.sendRedirect("/Six_Eagles/home");
		
		
	}
	
	//This function checks every input field to see if there is an empty field
	private boolean checkForEmptyString(String[] inputsList) {
		boolean empty = false;
		int i = 0;
		while (!empty && i < inputsList.length) {
			if (inputsList[i].isEmpty())
				empty = true;
			else
				i++;
		}
		
		return empty;
	}


}
