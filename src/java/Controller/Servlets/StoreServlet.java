package Controller.Servlets;

import Controller.AlbumHelper;
import Model.Album;
import Model.Artist;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jens
 */
public class StoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlbumHelper albumHelper = new AlbumHelper();
        List<Album> albumList = albumHelper.getAllAlbums();
        request.setAttribute("AlbumList", albumList);
        Hashtable<Album,Artist> albumArtistList = new Hashtable<>();
        
        for(Album album : albumList){
            albumArtistList.put(album,album.getArtist());
        }
        request.setAttribute("AlbumArtistList", albumArtistList);
        request.getRequestDispatcher("/listener/store.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
