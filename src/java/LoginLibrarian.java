/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author owner
 */
public class LoginLibrarian extends HttpServlet 
{
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    PrintWriter out=response.getWriter();
   
    String tablepassword=null;
    
   
    Statement st=null;
    ResultSet rs=null;
    
    try 
        {
            st=DBConnector.getStatement();

            String query = "SELECT Password from librarians where Name='"+name+"'";
           System.out.println("query= "+query);

            rs = st.executeQuery(query);

            if (rs.next()) 
            {
               tablepassword=rs.getString(1);
            }
            
        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }
    
    
    
   
    if(name!=null && password!=null && !name.trim().equals("") && password.equals(tablepassword))
    {
        HttpSession session=request.getSession(true);
        session.setAttribute("name", name);
        response.sendRedirect("LibrarianSection.jsp");
      
    }
    else
    {
        response.sendRedirect("LibrarianLogin.html");
       
   
    }
}
}
    


      
    

