/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;


import Controller.AlbumHelper;
import Controller.TrackHelper;
import Model.Album;
import Model.Track;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jens
 */
public class TrackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        TrackHelper trackHelper = new TrackHelper();
        Album album = (Album) session.getAttribute("album");
        List<Track> trackList = trackHelper.getAllTracks(album);
        request.setAttribute("TrackList", trackList);
        request.getRequestDispatcher("/listener/trackspage.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();     
    }
    
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
