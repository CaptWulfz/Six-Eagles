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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Roano
 */
@WebServlet(name = "addIngredientlists", urlPatterns = {"/addIngredientlists"})
public class addIngredientlists extends HttpServlet {

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
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
        /*    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addIngredientlists</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addIngredientlists at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }*/
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
        
        try {
            int Pcode = Integer.parseInt(request.getParameter("productAdds"));
            int IGcode = Integer.parseInt(request.getParameter("ingredientadd"));
            String name=ingredientslistsdao.viewingredientname(IGcode);
            Double amountadd = Double.parseDouble(request.getParameter("amountadd"));
            String unitadd = request.getParameter("unitadd");
        
        ingredientslists i = new ingredientslists(Pcode,IGcode, amountadd, unitadd,name);
        PrintWriter pw=response.getWriter();
        
        if(ingredientslistsdao.addingingredientslist(i)){
            request.getRequestDispatcher("ingredients_1.jsp").forward(request, response);
        }
        else{
        request.getRequestDispatcher("updateprodad.jsp").forward(request, response);
        //request.getRequestDispatcher("test.jsp").forward(request, response);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(addIngredientlists.class.getName()).log(Level.SEVERE, null, ex);
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
