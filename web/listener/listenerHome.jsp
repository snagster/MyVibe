<%-- 
    Document   : store
    Created on : 27-feb-2014, 18:00:14
    Author     : Jens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <h:head>
        <title>MyVibe - Store </title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </h:head>
    <h:body>
         <div class="container">
            <jsp:include page="header.jsp"/>
            <h1>Hello <c:out value="${sessionScope.user}" /></h1>
               
            <p>Relative Path: <c:out value="${pageContext.request.servletPath}" /></p>
                
            <c:if test="${param.success eq 'True'}">
                <div class="alert alert-success">
                    <strong>Welcome</strong>
                    You have been registered successfully!
                </div>
            </c:if>
                
            <c:if test="${param.success eq 'login'}">
                <div class="alert alert-success">
                    <strong>Welcome Back</strong>
                     You have been logged in successfully!
                </div>
            </c:if>               
        </div>
    </h:body>
</html>
