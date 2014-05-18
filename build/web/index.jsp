<%-- 
    Document   : index
    Created on : 2-mrt-2014, 20:54:41
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
           <nav class="navbar navbar-inverse" role="navigation">
                <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <a class="navbar-brand" style="margin-top: -10px;" href="index.jsp"><img src="img/MyVibe1.png" alt="Brand" height="42" width="42"/></a>
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
              
            <div class="jumbotron" style="margin-top:-20px;height:550px;">
                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger">
                        <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                        <%= request.getAttribute("error")%>
                    </div>
                <% } %>
                <% if (request.getAttribute("success") != null) { %>
                    <div class="alert alert-success">
                        <%= request.getAttribute("success")%>
                    </div>
                <% } %>
                <img src="img/MyVibe1.png" style="float:left; padding-right:75px;"/>
                <h1>Follow the music!</h1>
                <p>U bent op zoek naar muziek? Maak dan snel een account aan bij MyVibe! Hier kan u genieten van tal van
                exclusieve artiesten! Voor zeer aantrekkelijke prijzen bieden wij hun albums hier aan. U kan zelfs rechtstreeks
                hier
                op de website alle nummers beluisteren.</p>
                <!-- <p><a class="btn btn-primary btn-lg" role="button">Learn more</a></p> -->
                <br><br><br>
                
                   <section class="login" style="float:right; margin-top:-75px;">
                        <div class="title">Sign up now!</div>
                            <form action="register.jsp" method="post">
                                <input type="text" name="email" placeholder="E-mailadres" data-icon="x"/>
                                <input class="registreren" type="submit" value="sign up!"/>    
                            </form>
                </section>
            </div>  
        </div>
    </body>
</html>
