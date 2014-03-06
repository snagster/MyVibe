<%-- 
    Document   : register
    Created on : Feb 20, 2014, 1:53:21 PM
    Author     : Daan & Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Sign up</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>	
        <link rel="stylesheet" type="text/css" href="css/style_reg.css" />
        <link rel="stylesheet" href="jquery/jquery-ui.css"/>
        <script src="jquery/jquery-1.9.1.js"></script>
        <script src="noty-master/js/noty/jquery.noty.js"></script>
        <script src="noty-master/js/noty/layouts/bottom.js"></script>
        <script src="jquery/jquery-ui.js"></script>
        <script>
  $(function() {
    $(function() {
        $( "#datepicker" ).datepicker({
            dateFormat : 'dd/mm/yy',
            changeMonth : true,
            changeYear : true,
            yearRange: '-100y:c+nn'
        });
    });
  });
    window.onload = function(){
        var checker = document.getElementById('checkme');
        var firstname = document.getElementById('Firstname');
        var lastname = document.getElementById('Lastname');
        var contactnr = document.getElementById('ContactNr');
        var birthdate = document.getElementById('datepicker');
    // when unchecked or checked, run the function
    checker.onchange = function(){
        
    if(this.checked){
        firstname.placeholder = "Artiestnaam";
        lastname.className = "hidden";
        contactnr.className="";
        birthdate.placeholder="Actief sinds"; 
    } else {
        firstname.placeholder = "Voornaam";
        lastname.className = "";
        contactnr.className="hidden"; 
        birthdate.placeholder="Geboortedatum"; 
    }
    }
}
  </script>
    </head>
    <body>
        <div class="container">
           <nav class="navbar navbar-inverse" role="navigation" style="margin-left: -55px;width: 110%;">
                <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" style="margin-top: -10px;" href="#"><img src="img/MyVibe1.png" alt="Brand" height="42" width="42"/></a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                     <ul class="nav navbar-nav navbar-right">
                        <li><a href="login">Sign in</a></li> 
                    </ul>
                    
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
            <% if (request.getAttribute("error") != null) { %>
            <div class="alert alert-danger">
                <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                <%= request.getAttribute("error")%>
            </div>
                <% } %>
        <section class="login">
            <div class="title">Registreren</div>
            <form action="register" method="post">
                <input name="Username" type="text"  placeholder="Gebruikersnaam" data-icon="U" value="${param.Username}">
                <input type="text" name="email" placeholder="Email" data-icon="x" value="${param.email}">
                <input type="password" name="password" placeholder="Wachtwoord" data-icon="x"/>
                <input type="password" name="password2" placeholder="Herhaal wachtwoord" data-icon="x"/>
                <span style="padding-top:19px;">
                     <input type="checkbox" id="checkme" name="checked" style="width: 16px;height: 16px;margin-top: 15px"/>
                </span> 
                <span style="float:right; width: 184px;padding-left:10px;">Ik ben artiest</span>
                <input class="topradius" type="text" id="Firstname" name="Firstname" placeholder="Voornaam" value="${param.Firstname}">
                <input type="text" name="Lastname" id="Lastname" placeholder="Achternaam" value="${param.Lastname}">
                <input class="hidden" type="text" name="ContactNr" id="ContactNr" placeholder="Contactnr" value="${param.ContactNr}">
                <input type="text" id="datepicker" name="Birthdate" placeholder="Geboortedatum" value="${param.Birthdate}">
                
                <div class="aanmeldopties">
                     <div class="col"><a href="index.xhtml" title="Reeds geregistreerd">Reeds geregistreerd?</a></div>
                </div>
                <input class="registreren" type="submit" value="sign up!"/>
            </form>
        </section>
        </div>
    </body>
</html>