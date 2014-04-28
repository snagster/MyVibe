<%-- 
    Document   : export3
    Created on : 28-apr-2014, 10:17:59
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
            <h1>This is your export in html!</h1>
            <% ArrayList<String[]> temp_table= (ArrayList<String[]>)request.getAttribute("table_temp"); %>
            <% int rows = (Integer) request.getAttribute("rows"); %>
            
            <table class="table table-striped">
                <thead>
                    <tr>
                        <%for(int i = 0; i < rows ; i ++){ %>
                            <th><%= temp_table.get(0)[i]%></th>
                        <%} %>
                    </tr>
                <thead>
                <tbody>
                    <%for(int i = 1; i < temp_table.size() ; i ++){ %>
                        <tr>
                            <%for(int j = 0; j < rows ; j ++){ %>
                                <td><%= temp_table.get(i)[j]%></td>
                            <%} %>
                        </tr>
                   <%} %>
                    
                </tbody>
            </table>
        </div>
    </body>
</html>
