

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author owner
 */
public class LoginAdmin extends HttpServlet 
{
 
    
  
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    String name=request.getParameter("name");
    String password=request.getParameter("password");
    PrintWriter out=response.getWriter();
   String username="admin";
   String userpassword="admin123";
    if(name.equalsIgnoreCase(username) && password.equalsIgnoreCase(userpassword))
    {
        HttpSession session=request.getSession(true);
        session.setAttribute("username", name);
         
        response.sendRedirect("AdminSection.jsp");
    }
    
    else
    {
        response.sendRedirect("AdminLogin.html");
    }
}
}
      
   
