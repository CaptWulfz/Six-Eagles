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
 * @author Roano
 */
@WebServlet(name = "addProduct", urlPatterns = {"/addProduct"})
public class addProduct extends HttpServlet {

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
        
        String ProductName = request.getParameter("productName");
        double ProductPrice = Double.parseDouble(request.getParameter("productPrice"));
        int Stock = Integer.parseInt(request.getParameter("availableStock"));
        int Threshold = Integer.parseInt(request.getParameter("threshold"));
        int Ceiling = Integer.parseInt(request.getParameter("ceiling"));
        
        product p = null;
        
        try {
        	p = productdao.getProductByName(ProductName);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        if (p == null) {
        		if (ProductPrice > 0) {
        			if (Stock > 0) {
        				if (Threshold < Ceiling || (Threshold == 0 && Ceiling == 0)) {
        					p = new product(ProductName, ProductPrice, Stock, Threshold, Ceiling);
        					productdao.addNewProduct(p);
        					session.setAttribute("message", "Successfully Added New Product!!!");
        				} else {
        					session.setAttribute("message", "Treshold Cannot be Greater or Equal to the Ceiling!!!");
        				}
        			} else {
        				session.setAttribute("message", "Stock Cannot Be 0!!!");
        			}
        		} else {
        			session.setAttribute("message", "Product Price Cannot Be 0!!!");
        		}
        } else {
        	session.setAttribute("message", "Product Already Exists!!!");
        }
        
        response.sendRedirect("/Six_Eagles/inventory");
        
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
