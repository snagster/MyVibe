/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.ArtistHelper;
import Controller.ListenerHelper;
import Controller.TrackHelper;
import Controller.UserHelper;
import Model.Album;
import Model.Artist;
import Model.Listener;
import Model.Track;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException
    {
        AlbumHelper albumhelper = new AlbumHelper();
        //Album album = session.getAttribute("Album");
        TrackHelper tHelper = new TrackHelper();
        AlbumHelper aHelper = new AlbumHelper();
        List tracks = new ArrayList();
       // tracks.addAll(aHelper.getTracksFromAlbum(album));
        req.setAttribute("tracks", tracks);
        req.getRequestDispatcher("tracks.jsp").forward(req, resp);
    }
}
