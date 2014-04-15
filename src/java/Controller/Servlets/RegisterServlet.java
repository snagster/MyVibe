/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.ArtistHelper;
import Controller.ListenerHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 */
public class RegisterServlet extends HttpServlet {

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
        if(request.getParameter("checked")!= null && !request.getParameter("checked").equals("True")){
            if(request.getParameter("ContactNr") != null && request.getParameter("Firstname") != null
                    && request.getParameter("Birthdate") != null && request.getParameter("Username") != null
                    && request.getParameter("email") != null && request.getParameter("password") != null
                    && request.getParameter("ContactNr") != "" && request.getParameter("Firstname") != ""
                    && request.getParameter("Birthdate") != "" && request.getParameter("Username") != ""
                    && request.getParameter("email") != "" && request.getParameter("password") != ""
                    ){
                if(request.getParameter("password").equals(request.getParameter("password2"))){
                   ArtistHelper helper = new ArtistHelper();
                   try{
                        helper.createArtist(request.getParameter("Firstname"), helper.hashPassword(request.getParameter("password")), 
                            request.getParameter("Username"), request.getParameter("email"), new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("Birthdate")),
                                   request.getParameter("ContactNr"));

                        HttpSession session = request.getSession();
                        session.setAttribute("user", request.getParameter("Username"));
                        response.sendRedirect("listener/store.jsp?success=True");
                    } catch (ParseException ex) {
                        //meld de gebruiker dat het dataformat niet goed genoeg was
                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception e){
                    //meld de gebruiker dat er een probleem met de databank gebeurde. 
                    //throw e; 
                        request.setAttribute("error", e.getMessage()); 
                        request.getRequestDispatcher("/register.jsp").forward(request, response);
                    }
                }else{
                    request.setAttribute("error", "Beide paswoorden moeten gelijk zijn!"); 
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                } 
            } else{
                request.setAttribute("error", "Alle velden moeten ingevuld worden!"); 
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }else{
            //maak een nieuwe luisteraar
            if(request.getParameter("Lastname") != null && request.getParameter("Firstname") != null
                    && request.getParameter("Birthdate") != null && request.getParameter("Username") != null
                    && request.getParameter("email") != null && request.getParameter("password") != null
                    && request.getParameter("Lastname") != "" && request.getParameter("Firstname") != ""
                    && request.getParameter("Birthdate") != "" && request.getParameter("Username") != ""
                    && request.getParameter("email") != "" && request.getParameter("password") != ""
                    ){
                if(request.getParameter("password").equals(request.getParameter("password2"))){
                    ListenerHelper helper = new ListenerHelper(); 
                    try{
                        helper.createListener(request.getParameter("email"), helper.hashPassword(request.getParameter("password")), 
                            request.getParameter("Username"), request.getParameter("Firstname") + " " + 
                            request.getParameter("Lastname"), new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("Birthdate")));
                        
                        HttpSession session = request.getSession();
                        session.setAttribute("user", request.getParameter("Username"));
                        response.sendRedirect("listener/store.jsp?success=True");
                    } catch (ParseException ex) {
                        //meld de gebruiker dat het dataformat niet goed genoeg was
                        Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception e){
                    //meld de gebruiker dat er een probleem met de databank gebeurde. 
                    //throw e; 
                        request.setAttribute("error", e.getMessage()); 
                        request.getRequestDispatcher("/register.jsp").forward(request, response);
                    }

                }else{
                    request.setAttribute("error", "Beide paswoorden moeten gelijk zijn!"); 
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                } 
            } else{
                request.setAttribute("error", "Alle velden moeten ingevuld worden!"); 
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
            }

        }
    }
}
