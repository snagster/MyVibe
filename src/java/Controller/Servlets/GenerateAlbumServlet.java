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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        
        /*Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.parseInt(request.getParameter("albumjaar")));
        Date releasedate = calendar.getTime();*/
        int releasedate = Integer.parseInt(request.getParameter("albumjaar")); 
        UserHelper userhelper = new UserHelper();
        ArtistHelper artisthelper = new ArtistHelper();
        AlbumHelper albumhelper = new AlbumHelper();
        String albumnaam = request.getParameter("albumnaam");
        double albumprijs = Double.parseDouble(request.getParameter("albumprijs"));
        

        Artist artist = new Artist();
        HttpSession session = request.getSession();
        artist = (Artist) session.getAttribute("Artist");
        System.out.println(artist.getArtistRegDate());
        
        
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
                    try{
                    albumhelper.createAlbum(artist,albumnaam,releasedate,albumprijs);
                    } catch(Exception e) {
                        request.setAttribute("error", e.getMessage());
                    }
                }
            } else {
               request.setAttribute("error", "De ingegeven waarden lijken nog fouten te bevatten. Kijk alle velden na.");
            }
            /*session.setAttribute("user", request.getParameter("username"));*/
        }
        
        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }
}
