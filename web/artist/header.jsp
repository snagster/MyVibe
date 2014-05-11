<%-- 
    Document   : header
    Created on : 27-feb-2014, 18:04:47
    Author     : Laura & Daan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse" role="navigation">
   <div class="container-fluid">
   <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" style="margin-top: -10px;" href="artisthome.jsp"><img src="../img/MyVibe1.png" alt="Brand" height="42" width="42"/></a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <% if (request.getServletPath().equals("/artist/upload.jsp")) { %>
                    <li class="active"><a href="GenerateAlbumServlet">Upload</a></li>
                <% } else { %>
                    <li><a href="GenerateAlbumServlet">Upload</a></li>
                <% } %>
                
                <% if (request.getServletPath().equals("/artist/artistlibrary.jsp")) { %>
                    <li class="active"><a href="ArtistLibraryServlet">Mijn bibliotheek</a></li>
                <% } else { %>
                    <li><a href="ArtistLibraryServlet">Mijn bibliotheek</a></li> 
                <% } %>
                
                <% if (request.getServletPath().equals("/listener/reviews.jsp")) { %>
                    <li class="active"><a href="#">Mijn Reviews</a></li>
                <% } else { %>
                    <li><a href="#">Mijn Reviews</a></li> 
                <% } %>
                
                <% if (request.getServletPath().equals("/artist/ContractPanel.jsp")) { %>
                    <li class="active"><a href="ContractPanel.jsp">Contracten</a></li>
                <% } else { %>
                    <li><a href="ContractPanel.jsp">Contracten</a></li> 
                <% } %>
                
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a  class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-cog"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="mysettings"> My Settings</a></li>
                        <li><a href="../Logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        
            
                <form class="navbar-form navbar-right" style="width:250px;" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search"/>
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                    </div><!-- /input-group -->
                </form> 
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

