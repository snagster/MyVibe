<%-- 
    Document   : export2.jsp
    Created on : 27-apr-2014, 7:53:56
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
            <h1>Export data - step 2</h1>
        
            <%ArrayList<ArrayList<String>> tables= (ArrayList<ArrayList<String>>)request.getAttribute("tables"); %>   
            
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Selecteer de te exporteren velden - Gelieve 5 velden te selecteren</h3>
                   
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="ExportStep2">
                        <%int j = 0; %>
                        <%for (ArrayList<String> names : tables) {%>
                            <h4 class="col-sm-offset-1 col-sm-10"><%= names.get(0) %></h4>
                            <% int i = 1; %>
                            <% while( i < names.size() ){%>
                                <% int added = 1; %>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10"> 
                                        <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=j%>" value="<%=names.get(i) %>"><%=names.get(i) %>
                                        </label>
                                        <% if(i + 1 < names.size()){%>
                                            <% added ++ ;%>
                                            <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=j+1 %>" value="<%=names.get(i+1) %>"><%=names.get(i+1) %>
                                        </label>
                                        <% }%>
                                        <% if(i + 2 < names.size()){%>
                                            <% added ++ ;%>
                                            <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=j+2 %>" value="<%=names.get(i+2) %>"><%=names.get(i+2) %>
                                        </label>
                                        <% }%>
                                        <% if(i + 3 < names.size()){%>
                                            <% added ++ ;%>
                                            <label class="checkbox-inline" style="width:200px; height:35px;">
                                            <input type="checkbox" name="<%=j+3 %>" value="<%=names.get(i+3) %>"><%=names.get(i+3) %>
                                        </label>
                                        <% }%>
                                        <%i = i + added; %>
                                        <%j = j + added; %>
                                    </div>
                                </div>
                            <%}%>
                        
                        <% }%>
                        <input type="hidden" value="<%=j %>" name="aantal" />
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
