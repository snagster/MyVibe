<%-- 
    Document   : upload.jsp
    Created on : Apr 14, 2014, 12:18:57 PM
    Author     : Daan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload track</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <link href="artistcss.css" rel="stylesheet"/>
        <script>
            function validateForm(){
                var stop=false;
                var albumname=document.forms["GenerateAlbum"]["albumnaam"].value;
                var albumyear=document.forms["GenerateAlbum"]["albumjaar"].value;
                var albumprice=document.forms["GenerateAlbum"]["albumprijs"].value;
                var currentTime = new Date().getFullYear();
                if(albumname==null||albumname==""){
                    document.getElementById("albumnaam").style.borderColor="red";
                    stop=true;
                } else {
                    document.getElementById("albumnaam").style.borderColor="inherit";
                    stop=false;
                }
                if(albumyear==null||albumname==""||albumyear < 1500 || albumyear > currentTime){
                     document.getElementById("albumjaar").style.borderColor="red";
                     stop=true;
                } else {
                    document.getElementById("albumnaam").style.borderColor="none";
                    stop=false;
                } 
                 if(albumprice==null||albumprice=="" || albumprice > 30){
                      document.getElementById("albumprijs").style.borderColor="red";
                      stop=true;
                } else {
                    document.getElementById("albumnaam").style.borderColor="none";
                    stop=false;
                }
                if(stop==true){
                    return false;
                } else {
                    return true;
                }
            }
        </script>
    </head>
    <body>
        <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                <%= request.getAttribute("error")%>
            </div>
                <% } %>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="inputform">
            <div class="formheader">
            <h1>Creëer een album</h1>
            <p>Voordat je een track kunt uploaden moet je eerst het album creëren waartoe de track moet behoren.</p>
            </div>
            <form action="GenerateAlbumServlet" method="post" enctype="multipart/form-data" name="GenerateAlbum" onsubmit="return validateForm();" >
                <label for="albumnaam">Albumnaam</label><input type="text" name="albumnaam" id="albumnaam" maxlength="100"><br />
                <label for="albumjaar">Uitgavejaar</label><input type="number" name="albumjaar" id="albumjaar" maxlength="4"><br />
                <label for="albumprijs">Aankoopprijs (€)</label><input type="number" name="albumprijs" id="albumprijs" maxlength="10"><br />
                <div class="startbutton">
                <input type="submit" name="GenereerAlbum" value="Creëer album">
                </div>
            </form>
            </div>
            <div class="inputform">
            <div class="formheader">
            <h1>Upload een track</h1>
            <p>Het album waaraan je de track wilt toevoegen moet reeds aangemaakt zijn.</p>
            </div>
            <form action="UploadServlet" method="post" enctype="multipart/form-data" name="UploadTrack">
                <label for="muziekbestand">Muziekbestand</label>
                <input type="file" accept="audio/mp3" name="file"  size="50" /><br />
                <label for="Album">Album</label>
                <input type="text" name="albumnaam"><br />
                <div class="startbutton">
                <input type="submit" value="Upload track" />
                </div>
            </form>
            </div>
        </div>
    </body>
</html>
