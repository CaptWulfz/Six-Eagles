/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ClientOrderdao;
import dao.ingredientsdao;
import dao.ingredientslistsdao;
import dao.orderdetailsdao;
import dao.productdao;
import model.OrderDetails;
import model.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desmond
 */
@WebServlet(name = "vieworderdetails", urlPatterns = {"/vieworderdetails"})
public class vieworderdetails extends HttpServlet {

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
    	 int icode = Integer.parseInt(request.getParameter("submitBtn"));
         
         try{
        	 ArrayList<OrderDetails> orderDetails = orderdetailsdao.vieworderdetails(icode);
        	 ArrayList<product> prodList = new ArrayList<product>();
        	 for (OrderDetails od : orderDetails) {
        		 product p = productdao.getProduct(od.getProductCode());
        		 prodList.add(p);
        	 }
        	 
        	 request.setAttribute("orderDetails", orderDetails);
        	 request.setAttribute("prodList", prodList);
        	 request.getRequestDispatcher("vieworderdetails.jsp").forward(request, response);
         }
         catch(Exception e){
        	 e.printStackTrace();
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
