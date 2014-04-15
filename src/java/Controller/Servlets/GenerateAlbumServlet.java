/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.ArtistHelper;
import Controller.UserHelper;
import Model.Artist;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daan
 */
@MultipartConfig
public class GenerateAlbumServlet extends HttpServlet {
    private final static Logger LOGGER = 
            Logger.getLogger(UploadServlet.class.getCanonicalName());
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.parseInt(request.getParameter("albumjaar")));
        Date releasedate = calendar.getTime();
        UserHelper userhelper = new UserHelper();
        ArtistHelper artisthelper = new ArtistHelper();
        AlbumHelper albumhelper = new AlbumHelper();
        String albumnaam = request.getParameter("albumnaam");
        
        
        User user = new User();
        Artist artist = new Artist();
        HttpSession session = request.getSession();
        user = userhelper.getUserByUsername(session.getAttribute("user").toString());
        int userId = user.getUserId();
        System.out.println(artist.getArtistName());
        
        if(request.getParameter("albumnaam")==null){
            request.setAttribute("errorAlbumName", "Albumnaam moet ingevuld zijn.");
        } else {
            if(request.getParameter("albumnaam")!=null
                && request.getParameter("albumjaar")!=null
                && request.getParameter("albumprijs")!=null
                && Integer.parseInt(request.getParameter("albumjaar")) > 1500
                && Integer.parseInt(request.getParameter("albumjaar")) < currentyear
                && Integer.parseInt(request.getParameter("albumprijs")) > 0
                && Integer.parseInt(request.getParameter("albumprijs")) < 30
                ){
                if(albumhelper.albumExists(albumnaam)==1){
                    request.setAttribute("errorAlbumName", "Er bestaat reeds een album met die naam.");
                } else {
                    /*albumhelper.createAlbum(null, albumnaam, releasedate, currentyear);*/
                }
            } else {
               request.setAttribute("error", "De ingegeven waarden lijken nog fouten te bevatten. Kijk alle velden na.");
            }
            /*session.setAttribute("user", request.getParameter("username"));*/
        }
    }
}
