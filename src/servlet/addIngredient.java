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
import javax.servlet.http.HttpSession;

import java.sql.*;
import model.*;
import dao.*;

/**
 *
 * @author Desmond
 */
@WebServlet(name = "addIngredient", urlPatterns = {"/addIngredient"})
public class addIngredient extends HttpServlet {

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
        processRequest(request, response);
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
        
      //  int ingredientCode = Integer.parseInt(request.getParameter("ingredientCode"));
        String ingredientName = request.getParameter("ingredientName");
        double availableStock = Double.parseDouble(request.getParameter("availableStock"));
        int threshold = Integer.parseInt(request.getParameter("threshold"));
        int ceiling = Integer.parseInt(request.getParameter("ceiling"));
        String unitOfMeasurement = request.getParameter("unitOfMeasurement");
        
        ingredients i = null;
        
        try {
			i = ingredientsdao.getIngredientByName(ingredientName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        if (i == null) {
		        if (threshold < ceiling || (threshold == 0 && ceiling == 0)) {
		        	if (availableStock > 0) {
				        ingredients a = new ingredients(ingredientName, availableStock, threshold, ceiling, unitOfMeasurement);
				        ingredientsdao.addNewIngredients(a);
				        session.setAttribute("message", "Successfully Added New Ingredient!!!");
		        	} else
		        		session.setAttribute("message", "Stock cannot be 0!!!");
		        } else {
		        	session.setAttribute("message", "Treshold Cannot be Greater or Equal to the Ceiling!!!");
		        }
        } else {
        	session.setAttribute("message", "Ingredient Already Exists!!!");
        }
        	
        
        
        response.sendRedirect("/Six_Eagles/ingredients");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
