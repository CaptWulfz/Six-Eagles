/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.supplyordersdao;
import model.product;
import model.supplyorders;
import temporary_models.SupplyOrderItem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wacke
 */
@WebServlet(name = "addSupplyOrder", urlPatterns = {"/addSupplyOrder"})
public class addSupplyOrder extends HttpServlet {

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
        processRequest(request, response);
        
        HttpSession session = request.getSession();
        
        int SupplierID = Integer.parseInt(request.getParameter("supplierid"));
        String OrderDate = request.getParameter("orderDate");
        String DeliveryDate = request.getParameter("deliveryDate");
        String StatusID = request.getParameter("status");
        String Comment = "";
        
       // System.out.println("THE ORDER AND DELIVERY DATE: " + OrderDate + " " + DeliveryDate);
        
        supplyorders b = new supplyorders(SupplierID,0,OrderDate,DeliveryDate,StatusID,Comment);
        
        ArrayList<SupplyOrderItem> supplyOrdersCart = (ArrayList<SupplyOrderItem>) session.getAttribute("supplyOrdersCart");
        
        for (SupplyOrderItem item : supplyOrdersCart) {
        	product p = item.getProduct();
        	supplyorders sb = item.getSupplyOrders();
        	
        	if(supplyordersdao.addingSupplyOrder(sb)){
        		if ()
        	}
        	
        	
        }
        
        if(supplyordersdao.addingSupplyOrder(b)){
            request.getRequestDispatcher("supplyorders.jsp").forward(request, response);
        }
        else{
        request.getRequestDispatcher("updateprodad.jsp").forward(request, response);
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
