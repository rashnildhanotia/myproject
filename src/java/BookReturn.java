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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owner
 */
public class BookReturn extends HttpServlet {

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
        String Bookcallno=request.getParameter("bookcallno");
        String Studentid=request.getParameter("studentid");
        String Returneddate=request.getParameter("returneddate");
       
        
       pst=con.prepareStatement("insert into returnbooks(id,bookcallno,studentid,returneddate)values(?,?,?,?)");
       
         pst.setString(1,Id);
         pst.setString(2, Bookcallno);
         pst.setString(3, Studentid);
         pst.setString(4, Returneddate);
       
      
        row=pst.executeUpdate();
        if(row>0)
        {
          
          response.sendRedirect("Returned.html");
            
            
          
        }   
     
          
    }   
    catch (SQLException e) 
    {
          System.out.println(e); 
    } 
    catch (ClassNotFoundException e)
    {
             System.out.println(e); 
    }
}
}
