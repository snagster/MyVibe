<%-- 
    Document   : refreshpage
    Created on : May 2, 2014, 1:25:32 PM
    Author     : Daan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="2;URL=/MyVibe/artist/GenerateAlbumServlet">
        <link href="artistcss/progressbar.css" rel="stylesheet"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="progressbar.js" type="text/javascript" charset="utf-8"></script>
        <title>Verwerken...</title>
    </head>
    <body>
        <div id="container">
            <div id="progress_bar" class="ui-progress-bar ui-container">
                <div class="ui-progress" style="width: 79%;">
                    <span class="ui-label" style="display:none;">Verwerken <b class="value"></b></span>
      		</div><!-- .ui-progress -->
            </div><!-- #progress_bar -->  
            <div class="content" id="main_content" style="display: none;">
                <p>Hello, World!</p>
            </div><!-- #main_content -->
	</div><!-- #container -->
    </body>
</html>
