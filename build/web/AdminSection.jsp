<%-- 
    Document   : AdminSection
    Created on : Apr 30, 2020, 12:12:46 PM
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor='cyan'>
       
        <H1>Admin Section</H1>
        <a href='AddLibrarian.html'>Add Librarian</a><BR><BR>
        <a href='ViewLibrarian.jsp'>View Librarian</a><BR><BR>
        <a href='DeleteLibrarian.html'>Delete Librarian</a><BR><BR>
        <a href='AdminLogout.jsp'>LogOut</a>
        
        <%
            String name=(String)session.getAttribute("username");
            if(name==null || name.trim().equals(""))
            {
                response.sendRedirect("AdminLogin.html");
            }
        %>    
    </body>
   </html>
    </body>
</html>
