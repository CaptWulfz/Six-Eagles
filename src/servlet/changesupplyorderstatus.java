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
import model.*;
import dao.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author wacke
 */
@WebServlet(name = "changesupplyorderstatus", urlPatterns = {"/changesupplyorderstatus"})
public class changesupplyorderstatus extends HttpServlet {

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
        PrintWriter out = response.getWriter();
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
        doPost(request, response);
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
        processRequest(request, response);
        
        int code = Integer.parseInt(request.getParameter("pono"));
        String status = request.getParameter("status");
        
        try {
           supplyordersdao.changestatus(code, status);
           
           System.out.println(status);
           
           if (status.equals("Delivered")) {
        	   ArrayList<supplyorderdetails> sord = supplyorderdetailsdao.viewsupplyorderdetails(code);
        	   for (supplyorderdetails s : sord) {
        		   ingredients i = ingredientsdao.getIngredientByCode(s.getIngredientCode());
        		   double newQty = i.getStock() + s.getQuantity();
        		   ingredientsdao.updateIngredientQuantity(i.getIngredientCode(), newQty);
        	   }
        	   
           }
           
           response.sendRedirect("/Six_Eagles/viewSupplyOrders");
        } catch (SQLException ex) {
            Logger.getLogger(changesupplyorderstatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
