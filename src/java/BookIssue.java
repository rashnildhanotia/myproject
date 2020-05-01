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
public class BookIssue extends HttpServlet 
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
        String BookCallno=request.getParameter("bookcallno");
        String StudentId=request.getParameter("studentid");
        String StudentName=request.getParameter("studentname");
        String IssuedDate=request.getParameter("issueddate");
       
        
       pst=con.prepareStatement("insert into issuedbooks(id,bookcallno,studentid,studentname,issueddate)values(?,?,?,?,?)");
       
       pst.setString(1, Id);
       pst.setString(2, BookCallno);
       pst.setString(3, StudentId);
       pst.setString(4, StudentName);
       pst.setString(5, IssuedDate);
       
      
        row=pst.executeUpdate();
        if(row>0)
        {
          
          response.sendRedirect("Issued.html");
            
            
          
        }   
     
          
    }   
    catch (SQLException e) 
    {
          System.out.println(e); 
    } 
    catch (ClassNotFoundException ex)
    {
            Logger.getLogger(BookIssue.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

}
