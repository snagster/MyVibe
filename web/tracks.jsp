<%-- 
    Document   : tracks
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Tracks</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>	
        <link rel="stylesheet" type="text/css" href="css/style_reg.css" />
        <link rel="stylesheet" href="jquery/jquery-ui.css"/>

        <jsp:useBean id="Track" type="Model.Track" scope="session" />

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
            <nav class="navbar navbar-inverse" role="navigation" style="margin-left: -55px;width: 110%;">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" style="margin-top: -10px;" href="#"><img src="img/MyVibe1.png" alt="Brand" height="42" width="42"/></a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


                        <form class="nav navbar-nav navbar-form navbar-right form-inline" role="form" action="login" method="post">
                            <div class="form-group">
                                <label class="sr-only" for="exampleInputUser2">Email address</label>
                                <input type="username" class="form-control" id="exampleInputUser2" placeholder="Enter username" name="username"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="exampleInputPassword2">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" name="password"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Sign in</button>
                        </form>

                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div id="audioplayer">                
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
                    <%

                    %>
                </div>

            </div>  
        </div>
    </body>
</html>
