<%-- 
    Document   : tracks
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="../WEB-INF/tags/c.tld" prefix="c"%>
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
                        if (window.console && console.error("Error:" + e));
                    }
                }
            }
            function play()
                    {
                        Document.getElementById("audiofile").value = tracks.get(i).getTrackName();
                    }
                    $(document).ready(function()
		{
                    $("#rvF").toggle();
                    $("#review").click(function(evt)
			{
				$("#rvF").toggle(1000);
				 evt.preventDefault();
			});
                });
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
                <div id="tracklist">
                    <c:forEach var="track" items="${TrackList}">
                        <p>Naam:</p><p>${track.trackName}</p><br/>
                        <p>Lengte:</p><p>${track.trackLength}</p>
                    </c:forEach></br>
                </div>
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
