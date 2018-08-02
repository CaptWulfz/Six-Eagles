/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;

import model.*;
import temporary_models.CartItem;
import dao.*; 
import javax.servlet.http.HttpSession;

/**
 *
 * @author Desmond
 */
@WebServlet(name = "addClientOrder", urlPatterns = {"/addClientOrder"})
public class addClientOrder extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
       
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
       
    	HttpSession session = request.getSession();
    	
    	String actionToDo = request.getParameter("submitBtn");
    	
    	System.out.println("Change Client? " + actionToDo);
    	
    	if (actionToDo != null) {
	        int client = Integer.parseInt(request.getParameter("clientAddress"));
	        int PO= Integer.parseInt(request.getParameter("purchaseOrder"));
	  
	        String RD=request.getParameter("orderDate");
	        String DD=request.getParameter("deliveryDate");
	        
	        Users loginUser = (Users) session.getAttribute("loginUser");
	       
	        Orders NewOrder= new Orders(PO,client,loginUser.getUserId(),RD,DD);
	        if(ClientOrderdao.addnewClientOrder(NewOrder)) {
	            session.setAttribute("NewOrder", NewOrder);
	            //Added Cart
	            session.setAttribute("cart", new  ArrayList<CartItem>());
	            request.getRequestDispatcher("neworder2.jsp").forward(request, response); 
	        } else {  
	        	request.getRequestDispatcher("neworder.jsp").forward(request, response); 
	        }
        } else {
        	String selectedClientName = request.getParameter("clientName");
        	
        	session.setAttribute("selectedClientName", selectedClientName);
        	//System.out.println("NAME IS: " + session.getAttribute("selectedClientName"));
        	response.sendRedirect("/Six_Eagles/newClientOrder");
        }
        
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

}
}
