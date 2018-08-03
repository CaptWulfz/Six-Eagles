package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import temporary_models.CartItem;
import url_patterns.URLPatterns;

/**
 * Servlet implementation class ClientsServlet
 */
@WebServlet({URLPatterns.REMOVECLIENTORDER})
public class ClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsServlet() {
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
		// TODO Auto-generated method stub
		String pattern = request.getServletPath();
		
		switch (pattern) {
			case URLPatterns.REMOVECLIENTORDER:
				removeClientOrder(request, response);
				break;
		}
	}
	
	private void removeClientOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
		
		int index = Integer.parseInt(request.getParameter("submitButton"));
		
		cart.remove(index);
		
		session.setAttribute("cart", cart);
		
		response.sendRedirect("/Six_Eagles/newClientOrderDetails");
		
	}

}
