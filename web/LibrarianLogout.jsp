<%-- 
    Document   : LibrarianLogout
    Created on : Apr 30, 2020, 3:54:30 PM
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("LibraryManagement.jsp");
        %>
    </body>
</html>
