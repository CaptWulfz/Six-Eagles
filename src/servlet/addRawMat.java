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

/**
 *
 * @author Desmond
 */
@WebServlet(name = "addRawMat", urlPatterns = {"/addRawMat"})
public class addRawMat extends HttpServlet {

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
        
        int IGcode = Integer.parseInt(request.getParameter("ingredient"));
        String rawName = request.getParameter("brand");
        double packamount = Double.parseDouble(request.getParameter("packagingAmount"));
        String pack = request.getParameter("packaging");
        double Amount = Double.parseDouble(request.getParameter("Amount"));
        String unitOfMeasurement = request.getParameter("unitOfMeasurement");
        
        rawmaterials a = new rawmaterials(IGcode,rawName, packamount, pack, Amount, unitOfMeasurement);
        PrintWriter pw=response.getWriter();
        /*pw.println(a.getIngredientCode());
        pw.println(a.getIngredientBrand());
        pw.println(a.getPackagingAmount());
        pw.println(a.getPackaging());
        pw.println(a.getAmount());
        pw.println(a.getUnitOfMeasurement());
        */
        //request.setAttribute("testing", a.getIngredientName());
        //request.getRequestDispatcher("testing.jsp").forward(request, response);
        
        if(Addrawmatsdao.addingrawmats(a)){
            request.getRequestDispatcher("rawmats.jsp").forward(request, response);
        }
        else{
        request.getRequestDispatcher("updateprodad.jsp").forward(request, response);
        //request.getRequestDispatcher("test.jsp").forward(request, response);
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
   
}
