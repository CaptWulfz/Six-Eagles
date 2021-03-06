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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.*;
import excel_writer.ExcelWriter;
import jxl.write.WriteException;
import model.Client;
import model.Orders;
import model.ingredients;
import model.product;
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
        //processRequest(request, response);
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
         String Start=request.getParameter("start");
         String End=request.getParameter("end");
         
          int reportVal = Integer.valueOf(request.getParameter("drop"));
          if(reportVal==1){
            request.setAttribute("start", Start);
            request.setAttribute("end", End);
         
            try {
    			ArrayList<Orders> ordersList = ClientOrderdao.viewClientOrderByRange(Start, End);
    			ArrayList<Client> clientList = new ArrayList<Client>();
    			
    			for (Orders o : ordersList) {
    				Client c = clientdao.getClientByID(o.getClientID());
    				clientList.add(c);
    			}
    			
    			request.setAttribute("clientList", clientList);
    			request.setAttribute("ordersList", ordersList);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}

            request.getRequestDispatcher("SalesRep2.jsp").forward(request, response);
          }
          else if(reportVal==2){
            request.setAttribute("start", Start);
            request.setAttribute("end", End);
            
            try {
				ArrayList<ingredients> ingrList = ingredientsdao.viewIngredientactive();
				ArrayList<product> prodList = productdao.viewproductactive();
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				String dateToday = dtf.format(localDate);
				
				request.setAttribute("dateToday", dateToday);
				request.setAttribute("ingrList", ingrList);
				request.setAttribute("prodList", prodList);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
            request.getRequestDispatcher("InventoryRep.jsp").forward(request, response);
          }
          
         /*
          ExcelWriter writer = new ExcelWriter();
          try {
 			writer.writeExcel("C:\\Users\\JAROD\\Desktop");
 		} catch (WriteException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		*/

         
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
