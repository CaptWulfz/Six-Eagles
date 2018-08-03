package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SupplierStockService;
import temporary_models.SupplyOrderItem;
import url_patterns.URLPatterns;

/**
 * Servlet implementation class SuppliersServlet
 */
@WebServlet({URLPatterns.REMOVESUPPLYORDER,
			 URLPatterns.ADDSTOCK})
public class SuppliersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppliersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		System.out.println("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pattern = request.getServletPath();
		
		System.out.println("THE PATTERN IS: " + pattern);
		
		switch (pattern) {
			case URLPatterns.REMOVESUPPLYORDER:
				removeSupplyOrder(request, response);
				break;
			case URLPatterns.ADDSTOCK:
				addToSupplierStock(request, response);
				break;
		}
	}
	
	private void addToSupplierStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int supplierID = Integer.parseInt(request.getParameter("supplierName"));
		int ingredientID = Integer.parseInt(request.getParameter("ingredientName"));
		
		SupplierStockService.addSupplierStock(supplierID, ingredientID);
		
		response.sendRedirect("/Six_Eagles/suppliers");
		
	}
	
	private void removeSupplyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int index = Integer.parseInt(request.getParameter("submitButton"));
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<SupplyOrderItem> cart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
		
		cart.remove(index);
		
		session.setAttribute("supplyOrdersCart", cart);
		
		response.sendRedirect("/Six_Eagles/newSupplierOrder");
		
		
		
	}
}
