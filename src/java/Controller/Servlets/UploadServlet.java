package Controller.Servlets;

import Controller.AlbumHelper;
import Controller.TrackHelper;
import Model.Album;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 *
 * @author Daan
 */

@MultipartConfig
public class UploadServlet extends HttpServlet {
    private final static Logger LOGGER = 
            Logger.getLogger(UploadServlet.class.getCanonicalName());
   @Override
      public void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, java.io.IOException {
    response.setContentType("text/html;charset=UTF-8");
    
    // Create path components to save the file
    //Path waar track moet worden opgeslagen wordt gegenereerd op basis
    //van het geselecteerde album
    final String path = "c:/Tracks/" + request.getParameter("selectAlbum");
    
    //albumobject aanmaken om straks te gebruiken voor het aanmaken van een track
    AlbumHelper albumhelper = new AlbumHelper();
    TrackHelper trackhelper = new TrackHelper();
    Album album = albumhelper.getAlbumByAlbumname(request.getParameter("selectAlbum"));
    
    final Part filePart = request.getPart("file");
    final String fileName = getFileName(filePart);
    final PrintWriter writer = response.getWriter();
    String trackName = request.getParameter("tracknaam");
    
    if(request.getParameter("tracknaam")==null){
        request.setAttribute("error", "Albumnaam moet ingevuld zijn.");
    } else {
        //kijken of het geüploade bestand het mp3-formaat heeft
        if(fileName.indexOf(".mp3") == -1){
            LOGGER.log(Level.INFO, "Bestand {0} is geen mp3-bestand.", new Object[]{fileName, path});
            writer.println("Het geüploade bestand is geen mp3-bestand.");
        } else {
            OutputStream out = null;
            InputStream filecontent = null;
            try {
                //bestand aanmaken om naar te schrijven
                out = new FileOutputStream(new File(path + File.separator + trackName+".mp3"));
                
                //het bestand naar een variabele schrijven via InputStream
                filecontent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
        
                //het bestand naar het aangemaakte bestand schrijven
                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                
                writer.println("Bestand " + fileName + " is aangemaakt.");
                LOGGER.log(Level.INFO, "Bestand{0}wordt geüpload naar {1}", 
                new Object[]{fileName, path});
                request.getRequestDispatcher("/artist/refreshpage.jsp").forward(request, response);
        
            } catch (FileNotFoundException fne) {
                writer.println("Je hebt oftwel geen bestand geselecteerd of je "
                + "probeert een bestand te uploaden naar een beveiligde of "
                + "niet bestaande locatie.");
                writer.println("<br/> ERROR: " + fne.getMessage());

                LOGGER.log(Level.SEVERE, "Problemen tijdens file-uplaod. Error: {0}", 
                new Object[]{fne.getMessage()});
            }
        }
        try{
            //toevoegen van de track aan de database
            trackhelper.createTrack(album, trackName);
        } catch(Exception e){
            request.setAttribute("error", e.getMessage());
        }
        }
        
        
    }
      
private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}
}
