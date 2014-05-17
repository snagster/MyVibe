<%-- 
    Document   : store.jsp
    Created on : May 17, 2014, 7:42:22 PM
    Author     : Daan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/> 
                <c:forEach var="albumArtist" items="${AlbumArtistList}">
                    <p>${albumArtist.key.albumName}</p>
                    <p>${albumArtist.key.albumYear}</p>
                    <p>${albumArtist.value.artistName}</p>
                </c:forEach>
        </div>        
    </body>
</html>
