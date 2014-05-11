/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.TrackHelper;
import Model.Album;
import Model.Artist;
import Model.Genre;
import Model.Track;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daan
 */
public class ArtistLibraryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Artist artist = (Artist) session.getAttribute("Artist");
        AlbumHelper albumhelper = new AlbumHelper();
        TrackHelper trackhelper = new TrackHelper();
        List<Album> albumList = albumhelper.getAllAlbums(artist);
        
        request.setAttribute("AlbumList", albumList);

        request.getRequestDispatcher("/artist/artistlibrary.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
