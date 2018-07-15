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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.UUID;

import model.*;
import dao.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Desmond
 */
@WebServlet(name = "loginUser", urlPatterns = {"/loginUser"})
public class loginUser extends HttpServlet {

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
        HttpSession session=request.getSession();
        if(session.getAttribute("loginUser") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            //redirect to home page(user is already logged in.
        }
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
        HttpSession session=request.getSession();
        if(session.getAttribute("loginUser") == null){
            String Username =   request.getParameter("username");
            String Password = request.getParameter("password");

            Users LoginUser= new Users(Username,Password);


             if(Usersdao.Checklogin(LoginUser)!=null){
            	
            	 String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            	 System.out.println("uuid: " + uuid);
            	 
            	 LoginUser.setUserhash(uuid);
            	 
            	 Usersdao.updateUserHash(LoginUser);
            	 
            	 Cookie cookie = new Cookie("uuid", uuid);
            	 cookie.setMaxAge(60*30);
            	 response.addCookie(cookie);
            	 
            	 session.setMaxInactiveInterval(60*15);
 	 
            	 session.setAttribute("loginUser", LoginUser);
            	 response.sendRedirect("/Six_Eagles/home");
            }
            else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
