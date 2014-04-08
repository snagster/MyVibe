<%-- 
    Document   : tracks
    Created on : 6-mrt-2014, 10:20:03
    Author     : Jens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        
    </body>