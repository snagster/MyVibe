package org.apache.jsp.listener;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Album;
import java.util.ArrayList;
import Model.Track;

public final class tracks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>MyVibe - Tracks</title>\r\n");
      out.write("         <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            // Global variable to track current file name.\r\n");
      out.write("            var currentFile = \"\";\r\n");
      out.write("            function playAudio() {\r\n");
      out.write("                // Check for audio element support.\r\n");
      out.write("                if (window.HTMLAudioElement) {\r\n");
      out.write("                    try {\r\n");
      out.write("                        var oAudio = document.getElementById('myaudio');\r\n");
      out.write("                        var btn = document.getElementById('play');\r\n");
      out.write("                        var audioURL = document.getElementById('audiofile');\r\n");
      out.write("\r\n");
      out.write("                        //Skip loading if current file hasn't changed.\r\n");
      out.write("                        if (audioURL.value !== currentFile) {\r\n");
      out.write("                            oAudio.src = audioURL.value;\r\n");
      out.write("                            currentFile = audioURL.value;\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                        // Tests the paused attribute and set state. \r\n");
      out.write("                        if (oAudio.paused) {\r\n");
      out.write("                            oAudio.play();\r\n");
      out.write("                            btn.textContent = \"Pause\";\r\n");
      out.write("                        }\r\n");
      out.write("                        else {\r\n");
      out.write("                            oAudio.pause();\r\n");
      out.write("                            btn.textContent = \"Play\";\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                    catch (e) {\r\n");
      out.write("                        // Fail silently but show in F12 developer tools console\r\n");
      out.write("                        if (window.console && console.error(\"Error:\" + e))\r\n");
      out.write("                            ;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function changeSong(String)\r\n");
      out.write("            {\r\n");
      out.write("                // Check for audio element support.\r\n");
      out.write("                if (window.HTMLAudioElement)\r\n");
      out.write("                {\r\n");
      out.write("                    try\r\n");
      out.write("                    {\r\n");
      out.write("                        document.getElementById(\"audiofile\").setAttribute(\"value\", \".mp3\");\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("                    catch (e) {\r\n");
      out.write("                        // Fail silently but show in F12 developer tools console\r\n");
      out.write("                        if (window.console && console.error(\"Error:\" + e))\r\n");
      out.write("                            ;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("            function play()\r\n");
      out.write("                    {\r\n");
      out.write("                        Document.getElementById(\"audiofile\").value = tracks.get(i).getTrackName();\r\n");
      out.write("                    }\r\n");
      out.write("                    $(document).ready(function()\r\n");
      out.write("\t\t{\r\n");
      out.write("                    $(\"#rvF\").toggle();\r\n");
      out.write("                    $(\"#review\").click(function(evt)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(\"#rvF\").toggle(1000);\r\n");
      out.write("\t\t\t\t evt.preventDefault();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("                });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\" >\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("            <div id=\"audioplayer\" style=\"margin-left:auto; margin-right: auto; position:relative;\">                \r\n");
      out.write("                <p>\r\n");
      out.write("                    <input type=\"text\" id=\"audiofile\" size=\"80\" value=\"default.mp3\" />\r\n");
      out.write("                </p>\r\n");
      out.write("                <audio controls id=\"myaudio\">\r\n");
      out.write("                    HTML5 audio not supported\r\n");
      out.write("                </audio>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"jumbotron\" style=\"margin-top:-20px;height:550px;\">\r\n");
      out.write("                 ");
 ArrayList <Track> tracks = (ArrayList <Track> ) request.getAttribute("tracks");
                   //Album album = request.getAttribute("album");
                    
                    for (int i = 0; i < tracks.size(); i += 1) 
                    { 
                        //tracks.get(i).getTrackImage();
                        tracks.get(i).getTrackId();
                        tracks.get(i).getTrackName();
                        //album.getArtist();
                        //album.getAlbumName();
                        tracks.get(i).getAlbum();
                        tracks.get(i).getTrackGenre();   
                        
      out.write("\r\n");
      out.write("                        <input type=\"button\" value=\"Afspelen\" name=\"play\" onclick=\"play()\"/>\r\n");
      out.write("                          Naam: ");
      out.print(tracks.get(i).getTrackId());
      out.write("\r\n");
      out.write("                          Genre: ");
      out.print(tracks.get(i).getTrackGenre());
      out.write("\r\n");
      out.write("                          Lengte: ");
      out.print(tracks.get(i).getTrackLength());
      out.write("\r\n");
      out.write("                          Prijs: ");
      out.print(tracks.get(i).getTrackPrice());
      out.write("\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                    \r\n");
      out.write("                ");
if (request.getAttribute("error") != null) {
      out.write("\r\n");
      out.write("                <div class=\"alert alert-danger\">\r\n");
      out.write("                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>\r\n");
      out.write("                        ");
      out.print( request.getAttribute("error"));
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
 }
      out.write("\r\n");
      out.write("                <img src=\"img/MyVibe1.png\" style=\"float:left; padding-right:75px;\"/>\r\n");
      out.write("                <div>\r\n");
      out.write("                   \r\n");
      out.write("                    <a href=\"#\" id=\"review\"><p>Schrijf een Review</p> </a>\r\n");
      out.write("                    <form name=\"reviewForm\" id=\"rvF\" action=\"ReviewServlet\" method=\"POST\">\r\n");
      out.write("                        <textarea name=\"ReviewText\" rows=\"10\" cols=\"80\">\r\n");
      out.write("                        </textarea>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <input type=\"submit\" value=\"Insturen\" name=\"reviewSubmit\" />\r\n");
      out.write("                    </form>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>  \r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
