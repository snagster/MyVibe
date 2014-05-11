<%-- 
    Document   : artistlibrary.jsp
    Created on : May 10, 2014, 8:02:30 PM
    Author     : Daan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="../WEB-INF/tags/c.tld" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliotheek</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <link href="artistcss/artistcss.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger">
                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                    <%= request.getAttribute("error")%>
                </div>
            <% } %>
            
            <h1>Geüploade albums</h1>
            
            <c:forEach var="album" items="${AlbumList}">
                <div>
                    <p>${album.albumName}</p>
                    <p>${album.albumYear}</p>
                </div>
            </c:forEach>
            
            
            
                
        </div>
    </body>
</html>
