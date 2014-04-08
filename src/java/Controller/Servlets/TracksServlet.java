/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller.Servlets;

import Controller.UserHelper;
import Model.User;
import Controller.Servlets.TracksServlet;
import Controller.TracksHelper;
import Model.Album;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jens
 */
public class TracksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        Album album = new Album();
        TracksHelper helper = new TracksHelper(); 
        List tracks = new ArrayList();
        tracks.addAll(helper.getTracksFromAlbum(album));
        
    }
}
