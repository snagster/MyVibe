package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.GenreHelper;
import Model.Album;
import Model.Artist;
import Model.Genre;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    
    private List<Genre> genreList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //Helpers aanmaken
        AlbumHelper albumhelper = new AlbumHelper();
        GenreHelper genrehelper = new GenreHelper();
        
        //artiest opvragen uit sessievariabele
        Artist artist = (Artist) session.getAttribute("Artist");
        
        //alle albums van artiest in arraylist steken
        List<Album> list = albumhelper.getAllAlbums(artist);
        
        //alle genres ophalen uit db om straks op upload-pagina af te printen
        genreList = genrehelper.getAllGenres();
        
        //parameters meegeven
        request.setAttribute("AlbumList", list);
        request.setAttribute("GenreList", genreList);
        
        //dispatch naar uploadpagina
        request.getRequestDispatcher("/artist/upload.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int releasedate = Integer.parseInt(request.getParameter("albumjaar"));
        
        //arraylist maken waar genres in zullen komen die de artiest heeft aangeduid
        List<Genre> selectedGenres = new ArrayList<Genre>();
        
        GenreHelper genrehelper = new GenreHelper();
        
        //alle genres overlopen en per genre kijken of deze door arties is aangevinkt
        //en vervolgens toevoegen aan de arraylist met geselecteerde genres
        for(Genre genre : genreList){
            if(request.getParameter(genre.getGenreName())!=null){
                selectedGenres.add(genre);
            }
        }
        
        //de folder aanmaken waar de album en zijn tracks in moeten worden
        //opgeslagen
        new File("c:/Tracks").mkdir();
        
        //de folder aanmaken in de track-map met als naam de naam
        //van de album, hier worden bij het uploaden straks
        //de mp3-bestanden in geplaatst
        new File("c:/Tracks/" + request.getParameter("albumnaam")).mkdir();
        
        AlbumHelper albumhelper = new AlbumHelper();
        String albumnaam = request.getParameter("albumnaam");
        double albumprijs = Double.parseDouble(request.getParameter("albumprijs"))*10;

        
        HttpSession session = request.getSession();
        
        //artist opvragen uit sessievariabele
        Artist artist;
        artist = (Artist) session.getAttribute("Artist");
        
        //server side inputvalidation...
        if(request.getParameter("albumnaam")==null){
            request.setAttribute("error", "Albumnaam moet ingevuld zijn.");
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
                    request.setAttribute("error", "Er bestaat reeds een album met die naam.");
                } else {
                    try{
                        
                        
                    //als alle velden zijn ingevuld, mag het album aangemaakt worden
                    albumhelper.createAlbum(artist,albumnaam,releasedate,albumprijs);
                    
                    //het aangemaakte album opvragen en in een nieuw album-object
                    //plaatsen, dit is nodig om straks de genres aan het album
                    //toe te voegen.
                    Album album = albumhelper.getAlbumByAlbumname(albumnaam);
                    
                    //alle genres in de arraylist met geselecteerde genres
                    //overlopen en één voor één via helper in databank plaatsen
                    for(Genre genre : selectedGenres){
                        genrehelper.addAlbumGenre(genre, album);
                    }
                    
                    //redirect naar refreshpage. Dit is nodig om geupdate waarden
                    //uit databank opnieuw in te laden.
                    request.getRequestDispatcher("/artist/refreshpage.jsp").forward(request, response);
                    
                    //foutopvang
                    } catch(Exception e) {
                        request.setAttribute("error", e.getMessage());
                    }
                }
            } else {
               request.setAttribute("error", "De ingegeven waarden lijken nog fouten te bevatten. Kijk alle velden na.");
            }
        } 
    }
}
