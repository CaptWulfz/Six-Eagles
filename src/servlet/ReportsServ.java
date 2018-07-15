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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.*;
import dao.SalesRepdao;
/**
 *
 * @author AJ's Laptop
 */
@WebServlet(name = "ReportsServ", urlPatterns = {"/ReportsServ"})
public class ReportsServ extends HttpServlet {

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
        processRequest(request, response);
         String Start=request.getParameter("start");
         String End=request.getParameter("end");
          int reportVal = Integer.valueOf(request.getParameter("drop"));
          if(reportVal==1){
            request.setAttribute("start", Start);
            request.setAttribute("end", End);
            try {
                SalesRepdao.viewSales(Start, End);
            } catch (SQLException ex) {
                Logger.getLogger(ReportsServ.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("SalesRep2.jsp").forward(request, response);
          }
          else if(reportVal==2){
            request.setAttribute("start", Start);
            request.setAttribute("end", End);
            
            request.getRequestDispatcher("InventoryRep.jsp").forward(request, response);
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
