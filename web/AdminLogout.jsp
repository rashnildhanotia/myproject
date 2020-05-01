<%-- 
    Document   : AdminLogout
    Created on : Apr 30, 2020, 12:17:28 PM
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogOut</title>
    </head>
    <body>
   <%
            session.invalidate();
            response.sendRedirect("LibraryManagement.jsp");
        %>
    </body>
</html>
