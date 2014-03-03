<%-- 
    Document   : store
    Created on : 27-feb-2014, 18:00:14
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h:head>
        <title>MyVibe - Store </title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>	
    </h:head>
    <h:body>
         <div class="container">
            <jsp:include page="header.jsp"/>
            <h1>Hello <%= session.getAttribute( "user" ) %>!</h1>
                <p>Relative Path: <%= request.getServletPath() %></p>
                
                <% if (request.getParameter("success").equals("True")) { %>
                    <div class="alert alert-success">
                        <strong>Welcome</strong>
                        You have been registered successfully!
                    </div>
                <% } %>
                
                <% if (request.getParameter("success").equals("login") ) { %>
                    <div class="alert alert-success">
                        <strong>Welcome Back</strong>
                        You have been logged in successfully!
                    </div>
                <% } %>
         </div>
    </h:body>
</html>
