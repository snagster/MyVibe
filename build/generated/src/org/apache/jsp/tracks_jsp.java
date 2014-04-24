package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>MyVibe - Tracks</title>\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\t\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style_reg.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"jquery/jquery-ui.css\"/>\r\n");
      out.write("\r\n");
      out.write("        ");
      Model.Track Track = null;
      Track = (Model.Track) _jspx_page_context.getAttribute("Track", PageContext.SESSION_SCOPE);
      if (Track == null){
        throw new java.lang.InstantiationException("bean Track not found within scope");
      }
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\" >\r\n");
      out.write("            <nav class=\"navbar navbar-inverse\" role=\"navigation\" style=\"margin-left: -55px;width: 110%;\">\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("                    <!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("                    <div class=\"navbar-header\">\r\n");
      out.write("                        <a class=\"navbar-brand\" style=\"margin-top: -10px;\" href=\"#\"><img src=\"img/MyVibe1.png\" alt=\"Brand\" height=\"42\" width=\"42\"/></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <form class=\"nav navbar-nav navbar-form navbar-right form-inline\" role=\"form\" action=\"login\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"sr-only\" for=\"exampleInputUser2\">Email address</label>\r\n");
      out.write("                                <input type=\"username\" class=\"form-control\" id=\"exampleInputUser2\" placeholder=\"Enter username\" name=\"username\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label class=\"sr-only\" for=\"exampleInputPassword2\">Password</label>\r\n");
      out.write("                                <input type=\"password\" class=\"form-control\" id=\"exampleInputPassword2\" placeholder=\"Password\" name=\"password\"/>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\r\n");
      out.write("                        </form>\r\n");
      out.write("\r\n");
      out.write("                    </div><!-- /.navbar-collapse -->\r\n");
      out.write("                </div><!-- /.container-fluid -->\r\n");
      out.write("            </nav>\r\n");
      out.write("            <div id=\"audioplayer\">                \r\n");
      out.write("                <p>\r\n");
      out.write("                    <input type=\"text\" id=\"audiofile\" size=\"80\" value=\"default.mp3\" />\r\n");
      out.write("                </p>\r\n");
      out.write("                <audio controls id=\"myaudio\">\r\n");
      out.write("                    HTML5 audio not supported\r\n");
      out.write("                </audio>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"jumbotron\" style=\"margin-top:-20px;height:550px;\">\r\n");
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
      out.write(" \r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
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
