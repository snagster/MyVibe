package Controller.Servlets;

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
    /*final String path = getServletContext().getInitParameter("file-upload"); */
    final String path = "c:/Tracks/" + request.getParameter("selectAlbum");
    final Part filePart = request.getPart("file");
    final String fileName = getFileName(filePart);
    final PrintWriter writer = response.getWriter();
    
    if(fileName.indexOf(".mp3") == -1){
        LOGGER.log(Level.INFO, "File {0} is not an mp3-file!", new Object[]{fileName, path});
        writer.println("The file you uploaded is not an mp3-file!");
    } else {
    OutputStream out = null;
    InputStream filecontent = null;
    

    try {
        out = new FileOutputStream(new File(path + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        writer.println("New file " + fileName + " created at " + path);
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                new Object[]{fileName, path});
        request.getRequestDispatcher("/artist/refreshpage.jsp").forward(request, response);
    } catch (FileNotFoundException fne) {
        writer.println("You either did not specify a file to upload or are "
                + "trying to upload a file to a protected or nonexistent "
                + "location.");
        writer.println("<br/> ERROR: " + fne.getMessage());

        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                new Object[]{fne.getMessage()});
    } finally {
        if (out != null) {
            out.close();
        }
        if (filecontent != null) {
            filecontent.close();
        }
        if (writer != null) {
            writer.close();
        }
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
