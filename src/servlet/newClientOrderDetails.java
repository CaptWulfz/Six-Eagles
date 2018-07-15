/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClientOrderdao;
import dao.productdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Orders;
import model.OrderDetails;
import model.Users;
import model.product;
import temporary_models.CartItem;

class ButtonActions {
	public final static String ADDTOCART = "addToCart";
	public final static String CHECKOUT = "checkout";
	public final static String REMOVE = "Remove";
}

/**
 *
 * @author Desmond
 */
@WebServlet(name = "newClientOrderDetails", urlPatterns = {"/newClientOrderDetails"})

public class newClientOrderDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session=request.getSession();
    	if(session.getAttribute("loginUser") != null) {
    		String actionToDo = request.getParameter("submitButton");
    	
    		ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");
    	
    		System.out.println(actionToDo);
    	
    		if (actionToDo.equals(ButtonActions.ADDTOCART)) {

    			Orders cartItem = (Orders) session.getAttribute("NewOrder");
 
    			int ProdCode = Integer.parseInt(request.getParameter("productCode"));
    			int QTY= Integer.parseInt(request.getParameter("quantity"));
    			
	 	        // Get The Product Using the Product Code
	 	        try {
					product p = productdao.getProduct(ProdCode);
					CartItem newItem = new CartItem(ProdCode, p.getProductname(), QTY, p.getProductprice(), (p.getProductprice() * QTY));
					
					int index = itemExistsInCart(newItem.getName(), cart);
					
					if (index != -1) {
						CartItem existingItem = cart.get(index);
						
						existingItem.setQuantity(existingItem.getQuantity() + QTY);
						existingItem.setTotalPrice(existingItem.getQuantity() * existingItem.getPricePerPiece());
						
						cart.set(index, existingItem);
						
					} else {
						cart.add(newItem);			
					}
				} catch (SQLException e) {
					Logger.getLogger(newClientOrderDetails.class.getName()).log(Level.SEVERE, null, e);
				}
 	        
	 	       session.setAttribute("cart", cart);
	 	        
	 	       request.getRequestDispatcher("neworder2.jsp").forward(request, response);
	 	        
	    	} else if (actionToDo.equals(ButtonActions.CHECKOUT)){
	    		Orders Order = (Orders) session.getAttribute("NewOrder");
	    		
	    		cart = (ArrayList<CartItem>) session.getAttribute("cart");
	    		
    	        OrderDetails NewOrderDetails;
    	        
    	        for (CartItem item: cart) {
    	        	NewOrderDetails = new OrderDetails(Order.getPurchaseOrderNum(),item.getProductCode(),item.getPricePerPiece(),item.getQuantity());
    	        	ClientOrderdao.addnewClientOrderDetails(NewOrderDetails);
    	        }
    	        
    	        request.getRequestDispatcher("home.jsp").forward(request, response);
    	        
    	        /* Commented Out
    	        if(ClientOrderdao.addnewClientOrderDetails(NewOrderDetails)){
    	            request.getRequestDispatcher("neworder2.jsp").forward(request, response); 
    	               
    	        } else {     
    	        	request.getRequestDispatcher("neworder2.jsp").forward(request, response); 
    	        }
    	        */
    	        
	    		
	    		
	    	} else if (actionToDo.equals(ButtonActions.REMOVE)){
	    		
	    		cart = (ArrayList<CartItem>) session.getAttribute("cart");
	    		cart = new ArrayList<CartItem>();
	    		session.setAttribute("cart", cart);
	    		request.getRequestDispatcher("neworder2.jsp").forward(request,  response);
	    		
	    	}
	    } else {
	   		request.getRequestDispatcher("login.jsp").forward(request, response);  
	    }
    }
    
    private int itemExistsInCart(String name, ArrayList<CartItem> cart) {
    	
    	boolean found = false;
    	int i = 0;
    	while (i < cart.size() && !found) {
    		if (cart.get(i).getName().equals(name))
    			found = true;
    		else
    			i++;
    	}
    	
    	if (found)
    		return i;
    	else
    		return -1;
    }
    
}
