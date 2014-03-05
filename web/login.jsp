<%-- 
    Document   : login
    Created on : 5-mrt-2014, 13:19:37
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>	
        <link rel="stylesheet" type="text/css" href="css/style_reg.css" />
        <link rel="stylesheet" href="jquery/jquery-ui.css"/>
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
            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger">
                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                    <%= request.getAttribute("error")%>
                </div>
           <% } %>
           <section class="login">
                <div class="title">Registreren</div>
                    <form action="login" method="post">
                        <input name="username" type="text"  placeholder="Gebruikersnaam" data-icon="U" value="${param.username}">
                        <input type="password" name="password" placeholder="Password" data-icon="x">
                        
                        <div class="aanmeldopties">
                            <div class="col"><a href="index.xhtml" title="I forgot my password">Have you forgotten your password?</a></div>
                        </div>
                    <input class="registreren" type="submit" value="sign in!"/>
                    </form>
            </section>
        </div>
    </body>
</html>

