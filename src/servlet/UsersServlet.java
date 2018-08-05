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
 * Servlet implementation class UsersServlet
 */
@WebServlet({"/UsersServlet",
			 URLPatterns.ADDUSERTODB,
			 URLPatterns.UPDATEUSER})
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pattern = request.getServletPath();
		
		switch (pattern) {
		case URLPatterns.ADDUSERTODB:
			addUserToDB(request, response);
			break;
		case URLPatterns.UPDATEUSER:
			updateUser(request, response);
			break;
		}
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Users u = (Users) session.getAttribute("updatedUser");
		
		Usersdao.updateUser(u);
		
		Users currUser = (Users) session.getAttribute("loginUser");
		if (currUser.getPosition().equals(u.getPosition())) {
			session.setAttribute("loginUser", u);
		}
		
		session.setAttribute("updatedUser", null);
		
		response.sendRedirect("/Six_Eagles/home");
	}
	
	private void addUserToDB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String[] userDetails = (String[]) session.getAttribute("inputsList");
		
		Users u = new Users(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[5], userDetails[6]);
		
		if (Usersdao.getUserByUsername(u.getUsername()) == null) {
		
			Usersdao.addUser(u);
			
			session.setAttribute("inputsList", null);
			session.setAttribute("successMessage", "Successfully added a new user!!!");
			response.sendRedirect("/Six_Eagles/home");
		} else {
			session.setAttribute("inputsList", null);
			session.setAttribute("errorMessage", "Username already exists!!!");
			response.sendRedirect("/Six_Eagles/createUser");
		}
		
		
	}


}
