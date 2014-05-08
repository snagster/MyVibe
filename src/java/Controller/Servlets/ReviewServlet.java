/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.ArtistHelper;
import Controller.ReviewHelper;
import Controller.UserHelper;
import Model.Album;
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
 * @author Jens
 */
@MultipartConfig
public class ReviewServlet extends HttpServlet {
    private final static Logger LOGGER = 
            Logger.getLogger(UploadServlet.class.getCanonicalName());
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("listener/tracks.jsp").forward(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        

        Calendar calendar = Calendar.getInstance();
        Date reviewDate = calendar.getTime();
        UserHelper userhelper = new UserHelper();
        AlbumHelper albumhelper = new AlbumHelper();
        ReviewHelper reviewhelper = new ReviewHelper();
        //Album album = request.getParameter("Album");
        String reviewText = request.getParameter("ReviewText");

        User user = new User();
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("User");
        
                    try{
                    //reviewhelper.createReview(album,reviewText);
                    } catch(Exception e) {
                        request.setAttribute("error", e.getMessage());
                    }
                    request.getRequestDispatcher("tracks.jsp").forward(request, response);
                }
        
}