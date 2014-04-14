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
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="container">
            <h1>File upload</h1>
            Select a file to upload: <br />
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="file" size="50" />
                <br />
                <input type="submit" value="Upload File" />
            </form>
        </div>
    </body>
</html>
