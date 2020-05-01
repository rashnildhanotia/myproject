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
public class LibrarianAdd extends HttpServlet 
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
        String Name=request.getParameter("name");
        String Password=request.getParameter("password");
        String EmailId=request.getParameter("emailid");
        String Address=request.getParameter("address");
        String City=request.getParameter("city");
        String Contact=request.getParameter("contact");
        
       pst=con.prepareStatement("insert into librarians(Id,Name,Password,EmailId,Address,City,Contact)values(?,?,?,?,?,?,?)");
       
       pst.setString(1, Id);
       pst.setString(2, Name);
       pst.setString(3, Password);
       pst.setString(4, EmailId);
       pst.setString(5, Address);
       pst.setString(6,City);
       pst.setString(7, Contact);
       
        row=pst.executeUpdate();
        if(row>0)
        {
            
            
            response.sendRedirect("Added.html");
          
        }   
     
          con.close();
    }   
    catch (SQLException e) 
    {
          System.out.println(e); 
    } 
    catch (ClassNotFoundException ex)
    {
            Logger.getLogger(LibrarianAdd.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
        
    
       