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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author owner
 */
public class LibrarianDelete extends HttpServlet
{
      public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
          String Id=request.getParameter("id");
          Connection con = null;
          Statement st = null;
          PreparedStatement pst;
          try
          {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Librarians","root","root");
            System.out.println("Connected");

            pst = con.prepareStatement("DELETE FROM librarians where id = ?");
            pst.setString(1, Id); 
           

            int i = pst.executeUpdate();
          response.sendRedirect("Deleted.html");
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
      }
   
}
