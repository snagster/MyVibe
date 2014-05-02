/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.AlbumHelper;
import Model.Album;
import Model.Artist;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
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
    private final static Logger LOGGER = Logger.getLogger(UploadServlet.class.getCanonicalName());
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AlbumHelper albumhelper = new AlbumHelper();
        Artist artist;
        artist = (Artist) session.getAttribute("Artist");
        
        List<Album> list = albumhelper.getAllAlbums(artist);
        request.setAttribute("AlbumList", list);
        request.getRequestDispatcher("/artist/upload.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        
        int releasedate = Integer.parseInt(request.getParameter("albumjaar"));
        
        new File("c:/Tracks").mkdir();
        new File("c:/Tracks/" + request.getParameter("albumnaam")).mkdir();
        /*new File(request.getServletContext().getRealPath("Tracks") + "/" + request.getParameter("albumnaam")).mkdir();*/
        
 
        AlbumHelper albumhelper = new AlbumHelper();
        String albumnaam = request.getParameter("albumnaam");
        double albumprijs = Double.parseDouble(request.getParameter("albumprijs"));
        

        Artist artist;
        HttpSession session = request.getSession();
        artist = (Artist) session.getAttribute("Artist");
        
        
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
                    request.getRequestDispatcher("/artist/refreshpage.jsp").forward(request, response);
                    } catch(Exception e) {
                        request.setAttribute("error", e.getMessage());
                    }
                }
            } else {
               request.setAttribute("error", "De ingegeven waarden lijken nog fouten te bevatten. Kijk alle velden na.");
            }
        }
        
        /*request.getRequestDispatcher("upload.jsp").forward(request, response);*/
    }
}
