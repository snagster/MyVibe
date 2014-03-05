/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.UserHelper;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laura
 */
public class PasswordRecoveryServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("username") != null && request.getParameter("password") != null &&
                request.getParameter("username") != "" && request.getParameter("password") != "" &&
                request.getParameter("email") != null && request.getParameter("password2") != null &&
                request.getParameter("email") != "" && request.getParameter("password2") != ""){
            UserHelper helper = new UserHelper();
            if(request.getParameter("password").equals(request.getParameter("password2"))){
                try{
                    helper.updatePassword(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"));
                    request.setAttribute("success", "Uw passwoord werd succesvol gereset. U kan nu met uw nieuw passwoord"
                            + " aanmelden."); 
                    request.getRequestDispatcher("/passwordrecovery.jsp").forward(request, response);
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage()); 
                    request.getRequestDispatcher("/passwordrecovery.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("error", "Beide passwoorden moeten gelijk zijn!"); 
                request.getRequestDispatcher("/passwordrecovery.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "Gelieve alle velden in te vullen"); 
            request.getRequestDispatcher("/passwordrecovery.jsp").forward(request, response);
        }
    }

 
}
