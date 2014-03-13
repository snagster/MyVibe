<%-- 
    Document   : mySettings
    Created on : 8-mrt-2014, 16:17:47
    Author     : Laura
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h:head>
        <title>MyVibe - My Settings </title>
        <link href="../css/bootstrap.min.css" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
    </h:head>
    <h:body>
         <div class="container">
            <jsp:include page="header.jsp"/>
            <h1>My settings</h1>
             <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger">
                    <strong>Oh snap, something's wrong, maybe the following error could help you out?<br /></strong>
                    <%= request.getAttribute("error")%>
                </div>
           <% } %>
           <% if (request.getAttribute("success")!= null) { %>
                    <div class="alert alert-success">
                        <strong>Well done!</strong>
                        <%= request.getAttribute("success")%>
                    </div>
                <% } %>
            <div class="panel panel-default">
                <div class="panel-heading">General Account Settings</div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <tr>
                            <td>Name</td>
                            <td><%= request.getAttribute( "name" ) %></td>
                            <td style="text-align: center;">
                                <button style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editUserFullnameModal">
                                    Edit your name
                                </button>
                                <jsp:include page="modals/updateUserFullnameModal.jsp"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><%= session.getAttribute("user") %></td>
                            <td style="text-align: center;">
                                <button style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editUsernameModal">
                                    Edit Username
                                </button>
                                <jsp:include page="modals/updateUsernameModal.jsp"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><%= request.getAttribute("email") %></td>
                            <td style="text-align: center;">
                                <button style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editEmailModal">
                                    Edit email
                                </button>
                                <jsp:include page="modals/updateEmailModal.jsp"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Password</td>
                            <td></td>
                            <td style="text-align: center;">
                                <button style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editPasswordModal">
                                    Edit password
                                </button>
                                <jsp:include page="modals/updatePasswordModal.jsp"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Birthday</td>
                            <td><%= request.getAttribute("birthdate") %></td>
                            <td style="text-align: center;">
                                <button style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm glyphicon glyphicon-edit" data-toggle="modal" data-target="#editBirthdateModal">
                                    Edit birthdate
                                </button>
                                <jsp:include page="modals/updateBirthdateModal.jsp"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Registered Since</td>
                            <td><%= request.getAttribute("registered") %></td>
                            <td style="text-align: center;"></td>
                        </tr>
                        <tr>
                            <td>Amount of credits</td>
                            <td><%= request.getAttribute("credits") %> credits</td>
                            <td style="text-align: center;"><a href="#" style="width: 164px; height: 30px;" class="btn btn-primary btn-lg btn-sm" role="button">Get more credits</a></td>
                        </tr>
                    </table>
                            
                <button type="button" class="btn btn-danger col-sm-offset-10 col-sm-2" data-toggle="modal" data-target="#removeAccountModal">Remove this account</button>
                <jsp:include page="modals/removeAccountModal.jsp"/>
              </div>
            </div>
         </div>
    </h:body>
</html>
