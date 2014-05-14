package Controller.Servlets;

import Controller.ListenerHelper;
import Model.Listener;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jens
 */
public class CreditServlet extends HttpServlet {
    
    private Listener listener;
    private int credits;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //helper aanmaken
        ListenerHelper listenerHelper = new ListenerHelper();
        
        //listener-object opvragen
        listener = (Listener) session.getAttribute("Listener");
        
        //huidige credits van listener ophalen.
        credits = listener.getCredits();
        
        //aantal credits in attribute plaatsen om straks op pagina te
        //laten zien.
        request.setAttribute("credits", credits);
        
        //dispatcher naar credits-page.
        request.getRequestDispatcher("/listener/credits.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        //listener-object opvragen
        listener = (Listener) session.getAttribute("Listener");
        
        //value van de geselecteerde radiobutton opvragen.
        String choice = request.getParameter("plan");
        
        //helper aanmaken
        ListenerHelper listenerHelper = new ListenerHelper();
        
        //variabele voor toe te voegen credits.
        int creditsToAdd=0;
        
        //nagaan welke radiobutton de gebruiker heeft aangeklikt.
        switch (choice){
            case "plan_10":
                creditsToAdd=100;
                break;
            case "plan_15":
                creditsToAdd=150;
                break;
            case "plan_25":
                creditsToAdd=250;
                break;
            case "plan_50":
                creditsToAdd=500;
                break;
        }
        
        //update credits van gebruiker
        try{
            listenerHelper.updateCredits(listener.getUserID(), creditsToAdd, "add");
        } catch(Exception e){
            request.setAttribute("error", e.getMessage());
        }
        
        //redirect naar homepage
        response.sendRedirect("store.jsp?success=login");
        
    }
}
