package Controller.Servlets;

import Controller.UserHelper;
import Model.Admin;
import Model.Artist;
import Model.Listener;
import Model.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("username") != null && request.getParameter("password") != null &&
                request.getParameter("username") != "" && request.getParameter("password") != ""){
            //Check if username exists
            UserHelper helper = new UserHelper();
            
            
            if(helper.userExists(request.getParameter("username")) == 1){
                User user = helper.getUserByUsername(request.getParameter("username"));
                if(user.getUserPassword().equals(helper.hashPassword(request.getParameter("password")))){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", request.getParameter("username"));
                    
                    if(user instanceof Artist){
                    Artist artist = new Artist();
                    artist = (Artist) user;
                    session.setAttribute("Artist", artist);
                    request.setAttribute("ArtistName", artist.getArtistName());
                    response.sendRedirect("artist/artisthome.jsp?success=login");
                    }
                    if(user instanceof Listener){
                    Listener listener = new Listener();
                    listener = (Listener) user;
                    session.setAttribute("Listener", listener);
                    response.sendRedirect("listener/store.jsp?success=login");
                    }
                    if(user instanceof Admin){
                    Admin admin = new Admin();
                    admin = (Admin) admin;
                    session.setAttribute("Admin", admin);
       
                    }
                    
                    /*response.sendRedirect("artist/artisthome.jsp?success=login");*/
                }else{
                    request.setAttribute("error", "U gaf een foutief passwoord op. Probeer nogmaals."); 
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("error", "Er bestaat geen gebruiker met die username."); 
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", "Beide velden moeten worden ingevuld."); 
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
