/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajj;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Yashwanth
 */
@WebServlet(name = "Aj", urlPatterns = {"/Aj"})
public class Aj extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String name, no, ty;
        no=request.getParameter("a");
        name=request.getParameter("b");
        ty=request.getParameter("c");
        int x= Integer.parseInt(no);
        SessionFactory sf= new Configuration().configure().buildSessionFactory();
        Session s= sf.openSession();
        Transaction tr = s.beginTransaction();
        Hb t= new Hb(x,name,ty);
        s.save(t);
        tr.commit();
        s.close();  
        
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Aj</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Thankyou !! </br>Water will be delivered in 15 minutes</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
