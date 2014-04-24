package Controller.Servlets;

import Model.Artist;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daan
 */
public class ArtistPanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Artist artist = new Artist();
        HttpSession session = request.getSession();
        artist = (Artist) session.getAttribute("Artist");
        session.setAttribute("Artist", artist);
        request.setAttribute("ArtistName", artist.getArtistName());
        request.getRequestDispatcher("/artist/artisthome.jsp").forward(request, response);
    }


    /*@Override
    public String getServletInfo() {
        return "Short description";
    }*/
}
