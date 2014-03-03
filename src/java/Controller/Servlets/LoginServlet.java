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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 */
public class LoginServlet extends HttpServlet {

    

    

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
                request.getParameter("username") != "" && request.getParameter("password") != ""){
            //Check if username exists
            UserHelper helper = new UserHelper();
            if(helper.userExists(request.getParameter("username")) == 1){
                User user = helper.getUserByUsername(request.getParameter("username"));
                if(user.getUserPassword().equals(helper.hashPassword(request.getParameter("password")))){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", request.getParameter("username"));
                    response.sendRedirect("listener/store.jsp?success=login");
                }else{
                    request.setAttribute("error", "U gaf een foutief passwoord op. Probeer nogmaals."); 
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("error", "Er bestaat geen gebruiker met die username."); 
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "Beide velden moeten worden ingevuld."); 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
    }


}
