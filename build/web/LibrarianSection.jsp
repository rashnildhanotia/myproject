<%-- 
    Document   : LibrarianSection
    Created on : Apr 30, 2020, 3:24:13 PM
    Author     : owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="cyan">
        <H1>Librarian Section</H1>
        <a href='AddBooks.html'>Add Books</a><BR><BR>
        <a href='ViewBooks.jsp'>View Books</a><BR><BR>
        <a href='IssueBook.html'>Issue Book</a><BR><BR>
         <a href='ViewIssuedBooks.jsp'>View Issued Book</a><BR><BR>
          <a href='ReturnBook.html'>Return Book</a><BR><BR>
          <a href='ViewReturnedBook.jsp'>View Returned Books</a><BR><BR>
        <a href='LibrarianLogout.jsp'>LogOut</a>
        
        <%
            String name=(String)session.getAttribute("name");
            if(name==null || name.trim().equals(""))
            {
                response.sendRedirect("LibrarianLogin.html");
            }
        %>    
    </body>
</html>
