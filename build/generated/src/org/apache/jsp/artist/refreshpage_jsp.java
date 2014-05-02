package org.apache.jsp.artist;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class refreshpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta http-equiv=\"refresh\" content=\"4;URL=/MyVibe/artist/GenerateAlbumServlet\">\n");
      out.write("        <link href=\"artistcss/progressbar.css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n");
      out.write("        <script src=\"progressbar.js\" type=\"text/javascript\" charset=\"utf-8\"></script>\n");
      out.write("        <title>Verwerken...</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"container\">\n");
      out.write("            <div id=\"progress_bar\" class=\"ui-progress-bar ui-container\">\n");
      out.write("                <div class=\"ui-progress\" style=\"width: 79%;\">\n");
      out.write("                    <span class=\"ui-label\" style=\"display:none;\">Verwerken <b class=\"value\">79%</b></span>\n");
      out.write("      \t\t</div><!-- .ui-progress -->\n");
      out.write("            </div><!-- #progress_bar -->  \n");
      out.write("            <div class=\"content\" id=\"main_content\" style=\"display: none;\">\n");
      out.write("                <p>Hello, World!</p>\n");
      out.write("            </div><!-- #main_content -->\n");
      out.write("\t</div><!-- #container -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
