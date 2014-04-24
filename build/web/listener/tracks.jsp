<%-- 
    Document   : tracks
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page import="Model.Album"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Track"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Tracks</title>
         <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>

       

        <script type="text/javascript">
            // Global variable to track current file name.
            var currentFile = "";
            function playAudio() {
                // Check for audio element support.
                if (window.HTMLAudioElement) {
                    try {
                        var oAudio = document.getElementById('myaudio');
                        var btn = document.getElementById('play');
                        var audioURL = document.getElementById('audiofile');

                        //Skip loading if current file hasn't changed.
                        if (audioURL.value !== currentFile) {
                            oAudio.src = audioURL.value;
                            currentFile = audioURL.value;
                        }

                        // Tests the paused attribute and set state. 
                        if (oAudio.paused) {
                            oAudio.play();
                            btn.textContent = "Pause";
                        }
                        else {
                            oAudio.pause();
                            btn.textContent = "Play";
                        }
                    }
                    catch (e) {
                        // Fail silently but show in F12 developer tools console
                        if (window.console && console.error("Error:" + e))
                            ;
                    }
                }
            }

            function changeSong(String)
            {
                // Check for audio element support.
                if (window.HTMLAudioElement)
                {
                    try
                    {
                        document.getElementById("audiofile").setAttribute("value", ".mp3");

                    }
                    catch (e) {
                        // Fail silently but show in F12 developer tools console
                        if (window.console && console.error("Error:" + e))
                            ;
                    }
                }
            }

        </script>

    </head>
    <body>
        <div class="container" >
            <jsp:include page="header.jsp"/>
            <div id="audioplayer" style="margin-left:auto; margin-right: auto; position:relative;">                
                <p>
                    <input type="text" id="audiofile" size="80" value="default.mp3" />
                </p>
                <audio controls id="myaudio">
                    HTML5 audio not supported
                </audio>
            </div>
            <div class="jumbotron" style="margin-top:-20px;height:550px;">
                <%if (request.getAttribute("error") != null) {%>
                <div class="alert alert-danger">
                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                        <%= request.getAttribute("error")%>
                </div>
                <% }%>
                <img src="img/MyVibe1.png" style="float:left; padding-right:75px;"/>
                <div>
                    <% ArrayList <Track> tracks = (ArrayList <Track> ) request.getAttribute("tracks");
                   // Album album = request.getAttribute("album");
                    
                    for (int i = 0; i < tracks.size(); i += 1) 
                    { 
                        //tracks.get(i).getTrackImage();
                        tracks.get(i).getTrackId();
                        tracks.get(i).getTrackName();
                        //album.getArtist();
                        tracks.get(i).getAlbum();
                        tracks.get(i).getTrackGenre();   
                        %>
                        <input type="button" value="Afspelen" name="play" onclick="play()"/>
                          Naam: <%=tracks.get(i).getTrackId()%>
                          Genre: <%=tracks.get(i).getTrackGenre()%>
                          Lengte: <%=tracks.get(i).getTrackLength()%>
                          Prijs: <%=tracks.get(i).getTrackPrice()%>
                    <%}%>
                    
                  
                    
                </div>
                
            </div>  
        </div>
                <script>
                    function play()
                    {
                        Document.getElementById("audiofile").value = tracks.get(i).getTrackName();
                    }
                </script>
    </body>
</html>
