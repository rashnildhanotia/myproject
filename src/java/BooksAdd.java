/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owner
 */
public class BooksAdd extends HttpServlet 
{

     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
           PreparedStatement pst;
           Connection con;
           PrintWriter out=response.getWriter();
           int row;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        
        con=DriverManager.getConnection("jdbc:mysql://localhost/Librarians","root","root");
       
        
        String Id=request.getParameter("id");
        String Callno=request.getParameter("callno");
        String Name=request.getParameter("name");
        String Author=request.getParameter("author");
        String Publisher=request.getParameter("publisher");
       
       
        
       pst=con.prepareStatement("insert into viewbooks(id,callno,name,author,publisher)values(?,?,?,?,?)");
       
       pst.setString(1, Id);
       pst.setString(2, Callno);
       pst.setString(3, Name);
       pst.setString(4, Author);
       pst.setString(5, Publisher);
       
        row=pst.executeUpdate();
        if(row>0)
        {
            
            
            response.sendRedirect("BookAdd.html");
          
        }   
     
          con.close();
    }   
    catch (SQLException e) 
    {
          System.out.println(e); 
    } 
    catch (ClassNotFoundException ex)
    {
            Logger.getLogger(BooksAdd.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
        
   

