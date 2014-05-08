/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.ArtistHelper;
import Controller.ListenerHelper;
import Controller.TrackHelper;
import Controller.UserHelper;
import Model.Artist;
import Model.Listener;
import Model.Track;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 */
public class TrackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        TrackHelper helper = new TrackHelper();
        List<Track> t = helper.getAllTracks(session.getAttribute("album").toString()); 

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
    
        
        
        this.doGet(request, response);
    }

}
