/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.clientdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;

/**
 *
 * @author AJ's Laptop
 */
@WebServlet(name = "clientSort", urlPatterns = {"/clientSort"})
public class clientSort extends HttpServlet {

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
       
        int sortNum = Integer.valueOf(request.getParameter("fDown"));
         ArrayList<Client>cl = new ArrayList<Client>();
         
         String sortBy="";
         
        try {
            if(sortNum==1){
                cl=clientdao.viewClientactive();
                sortBy="Sort Type: Default";
            }else if(sortNum==2){
                cl=clientdao.viewAscClient();
                sortBy="Sort Type:Ascending by Client Name";   
            }else if(sortNum==3){
                cl=clientdao.viewDescClient();
                sortBy="Sort Type:Descending by Client Name";
            }else if(sortNum==4){
                cl=clientdao.viewAscCity();
                sortBy="Sort Type: Ascending by City Name";
            }else if(sortNum==5){
                cl=clientdao.viewDescCity();
                sortBy="Sort Type: Descending by City Name";
            }
        } catch (SQLException ex) {
            Logger.getLogger(clientSort.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("clientList", cl);
        request.setAttribute("SortedBy", sortBy);
        request.getRequestDispatcher("client.jsp").forward(request, response);
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
