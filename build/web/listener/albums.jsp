<%-- 
    Document   : Album
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page import="Model.Album"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Track"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Mijn Albums</title>
         <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>

    </head>
    <body>
        <div class="container" >
            <jsp:include page="header.jsp"/>
            <div>
                
            </div>
            <div class="jumbotron" style="margin-top:-20px;height:550px;">
                 <% ArrayList <Album> albums = (ArrayList <Album> ) request.getAttribute("albums");
                   //Album album = request.getAttribute("album");
                    
                    for (int i = 0; i < albums.size(); i += 1) 
                    { 
                        albums.get(i).getAlbumId();
                        albums.get(i).getAlbumThumbnail();   
                        %>

                          Naam: <%=albums.get(i).getAlbumName()%>
                          Artiest: <%=albums.get(i).getArtist()%>
                          <!-- Genre: <//%= albums.get(i).getGenreAlbums()%> -->
                          Jaar: <%=albums.get(i).getAlbumYear()%>
                          Prijs: <%=albums.get(i).getAlbumPrice()%>
                          <input type="submit" value="Open Tracks" name="toTracks" />
                    <%}%>
                    
                <%if (request.getAttribute("error") != null) {%>
                <div class="alert alert-danger">
                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                        <%= request.getAttribute("error")%>
                </div>
                <% }%>
                <img src="img/MyVibe1.png" style="float:left; padding-right:75px;"/>
                <div>
                   
                    <a href="#" id="review"><p>Schrijf een Review</p> </a>
                    <form name="reviewForm" id="rvF" action="ReviewServlet" method="POST">
                        <textarea name="ReviewText" rows="10" cols="80">
                        </textarea>
                        <br>
                        <input type="submit" value="Insturen" name="reviewSubmit" />
                    </form>
                    
                </div>
                
            </div>  
        </div>
    </body>
</html>
