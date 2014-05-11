/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;


import Model.Album;
import Model.Listener;
import Model.User;
import java.io.IOException;
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
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("listener/tracks.jsp").forward(req, resp);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 
        
        /*Album album = request.getParameter("Album");*/
        HttpSession session = request.getSession();
        Listener listener = (Listener) session.getAttribute("Listener");
        
                    try{
                    //reviewhelper.createReview(album,reviewText);
                    } catch(Exception e) {
                        request.setAttribute("error", e.getMessage());
                    }
                    request.getRequestDispatcher("tracks.jsp").forward(request, response);
                }
        
}