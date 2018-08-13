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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.*;
import dao.*;

/**
 *
 * @author Desmond
 */
@WebServlet(name = "makeProduct", urlPatterns = {"/makeProduct"})
public class makeProduct extends HttpServlet {

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
        int ProductCode = Integer.parseInt(request.getParameter("Prodname"));
        int QTY = Integer.parseInt(request.getParameter("makeqty"));
         boolean makeP=false;
        try {
            makeP=productdao.makeProduct(ProductCode,QTY);
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    		LocalDate localDate = LocalDate.now();
    		
    		String dateToday = dtf.format(localDate);
    		String expiryDate = dtf.format(localDate.plusDays(30));
    		
    		for (int i = 0; i < QTY; i++)
    			productdao.setConsumableDates(ProductCode, dateToday, expiryDate);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
        if(makeP)
        	response.sendRedirect("/Six_Eagles/inventory");
	    else
	       response.sendRedirect("/Six_Eagles/home");
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
