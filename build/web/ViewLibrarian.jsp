<%-- 
    Document   : ViewLibrarian
    Created on : Apr 29, 2020, 4:46:53 PM
    Author     : owner
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="cyan">
         <form action="OK" method="post"> 
       
        <%
            Connection con=null;
            Statement st=null;
            ResultSet rs=null;
             try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librarians","root","root");
            System.out.println("Connected");

            st = con.createStatement();

            String query = "SELECT * from librarians";

            rs = st.executeQuery(query);
        %>
            <table width="500px" border="1">
                <tr>
                    <td><B>Id</B></td>
                    <td><B>Name</B></td>
                    <td><B>Password</B></td>
                    <td><B>EmailId</B></td>
                    <td><B>Address</B></td>
                    <td><B>City</B></td>
                    <td><B>Contact</B></td>
                    
                    
                    
                </tr>
        
        <%
            while (rs.next()) 
            {
        %>
        
        <tr>
            <td><B><%=rs.getString(1)%></B></td>
            <td><B><%=rs.getString(2)%></B></td>
            <td><B><%=rs.getString(3)%></B></td>
            <td><B><%=rs.getString(4)%></B></td>
            <td><B><%=rs.getString(5)%></B></td>
            <td><B><%=rs.getString(6)%></B></td>
            <td><B><%=rs.getString(7)%></B></td>
            
           
        </tr>
       
           
          
        <%
            }
            con.close();
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println(e);
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
          
       %>
        </table>
       <table>
           
              <tr>
                    <td></td>
                    <td><input type="submit" value="OK" /></td>
                </tr>
                
               </table>
        
                 
 
         
        
        
       </form> 
        
    </body>
</html>