/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.ArtistHelper;
import Controller.ListenerHelper;
import Controller.UserHelper;
import Model.Artist;
import Model.Listener;
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
public class mySettingsServlet extends HttpServlet {
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
        HttpSession session = request.getSession();
        UserHelper helper = new UserHelper();
        User u = helper.getUserByUsername(session.getAttribute("user").toString()); 
        if(u instanceof Listener){
            Listener listener = (Listener) u; 
            request.setAttribute("name", listener.getListenerFullName());
            request.setAttribute("email", listener.getUserEmail());
            request.setAttribute("birthdate", listener.getListenerBirthDate());
            request.setAttribute("registered", listener.getUserRegDate()); 
            request.setAttribute("credits", listener.getCredits()); 
            request.getRequestDispatcher("mySettings.jsp").forward(request, response);
        }
        if (u instanceof Artist){
            Artist artist = (Artist) u; 
            request.setAttribute("name", artist.getArtistName()); 
            request.setAttribute("email", artist.getUserEmail()); 
            request.setAttribute("birthdate", artist.getSinceDate());
            request.setAttribute("registered", artist.getUserRegDate()); 
            request.getRequestDispatcher("mySettings.jsp").forward(request, response); 
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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        UserHelper userhelper = new UserHelper();
        User u = userhelper.getUserByUsername(session.getAttribute("user").toString()); 
        if(request.getParameter("oldPW")!= null && !request.getParameter("oldPW").equals("") 
                && request.getParameter("newPW")!= null && !request.getParameter("newPW").equals("")
                && request.getParameter("newPWconfirmed")!= null && !request.getParameter("newPWconfirmed").equals(
                   request.getParameter(""))){
            if(request.getParameter("newPWconfirmed").equals(request.getParameter("newPW"))){
                if(u.getUserPassword().equals(userhelper.hashPassword(request.getParameter("oldPW")))){
                    try{
                        userhelper.updatePassword(u.getUsername(), u.getUserEmail(), request.getParameter("newPW"));
                        request.setAttribute("success", "Your password is successfully updated");
                    }catch(Exception e){
                       request.setAttribute("error", e.getMessage()); 
                    }
                }else{
                    request.setAttribute("error", "Er trede een fout op in de identificatie: u gaf niet het"
                            + " juiste passwoord op." );
                }
            }else{
                request.setAttribute("error", "Je moet tweemaal hetzelfde passwoord opgeven" );
            }
        }
        
        int userId = u.getUserId(); 
        if( u instanceof Listener){
            ListenerHelper helper = new ListenerHelper();
            if(request.getParameter("username") != null && !request.getParameter("username").equals("")){ 
                try{
                  helper.update(userId, "username", request.getParameter("username"));
                    request.setAttribute("success", "The username is successfully updated"); 
                    session.setAttribute("user", request.getParameter("username"));
                }
                catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }else if(request.getParameter("firstname") != null && !request.getParameter("firstname").equals("")
                    && request.getParameter("name") != null && !request.getParameter("name").equals("")){
                String name = request.getParameter("firstname") + " " + request.getParameter("name"); 
                try{
                    helper.update(userId, "fullname", name); 
                    request.setAttribute("success", "Your name is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }else if(request.getParameter("birthdate")!= null && !request.getParameter("birthdate").equals("")){
                try{
                    helper.update(userId, "birthdate", request.getParameter("birthdate").toString()); 
                    request.setAttribute("success", "Your birthdate is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }else if(request.getParameter("email")!= null && !request.getParameter("email").equals("")){
                try{
                    helper.update(userId, "email", request.getParameter("email")); 
                    request.setAttribute("success", "Your email is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }       
        } else if( u instanceof Artist){
            ArtistHelper helper = new ArtistHelper();
            if(request.getParameter("username") != null && !request.getParameter("username").equals("")){ 
                try{
                  helper.update(userId, "username", request.getParameter("username"));
                    request.setAttribute("success", "The username is successfully updated"); 
                    session.setAttribute("user", request.getParameter("username"));
                }
                catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }
            else if(request.getParameter("birthdate")!= null && !request.getParameter("birthdate").equals("")){
                try{
                    helper.update(userId, "sincedate", request.getParameter("birthdate").toString()); 
                    request.setAttribute("success", "Your founded date is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }else if(request.getParameter("email")!= null && !request.getParameter("email").equals("")){
                try{
                    helper.update(userId, "email", request.getParameter("email")); 
                    request.setAttribute("success", "Your email is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            } else if(request.getParameter("name") != null && !request.getParameter("name").equals("")){
                String name = request.getParameter("name"); 
                try{
                    helper.update(userId, "name", name); 
                    request.setAttribute("success", "Your name is successfully updated"); 
                }catch(Exception e){
                    request.setAttribute("error", e.getMessage());
                }
            }      
        }
        
        
        this.doGet(request, response);
    }

}
