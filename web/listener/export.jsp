<%-- 
    Document   : export
    Created on : 26-apr-2014, 16:42:07
    Author     : Laura
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyVibe - Export </title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <h1>Export data</h1>
            <%ArrayList<String> tablenames= (ArrayList<String>)request.getAttribute("tables"); %>   
            
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Selecteer de te exporteren tabellen</h3>
                </div>
                <div class="panel-body">
                    
                    <form role="form" method="post">
                            <% int i = 0; %>
                            <% while( i < tablenames.size() ){%>
                                <% int added = 1; %>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=tablenames.get(i) %>" value="true"><%=tablenames.get(i) %>
                                        </label>
                                        <% if(i + 1 < tablenames.size()){%>
                                            <% added ++ ;%>
                                            <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=tablenames.get(i+1) %>" value="true"><%=tablenames.get(i+1) %>
                                        </label>
                                        <% }%>
                                        <% if(i + 2 < tablenames.size()){%>
                                            <% added ++ ;%>
                                            <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=tablenames.get(i+2) %>" value="true"><%=tablenames.get(i+2) %>
                                        </label>
                                        <% }%>
                                        <%i = i + added; %>
                                    </div>
                                </div>
                            <%}%>
                        <div class="form-group">
                            <div class="col-sm-offset-10 col-sm-10">
                                <button type="submit" class="btn btn-primary">Selecteer</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
