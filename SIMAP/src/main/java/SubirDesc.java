/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
public class SubirDesc extends HttpServlet {
    private Connection con;
    private Statement set;
    private ResultSet rs;
    public void init(ServletConfig cfg)throws ServletException{
        String URL="jdbc:mysql://yw3blbopseve.us-east-1.psdb.cloud/simap";
        String userName="9qlsw3zv1qf1";
        String password="pscale_pw_w1MXJA3BBKZnOtFfAApP1muX05a4bS4F0A8X2qES79c";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL,userName, password);
            set=con.createStatement();
            System.out.println("Se concecto a la BD");
            System.out.println(URL);
            System.out.println(userName);
            System.out.println(password);
        }catch(Exception e){
            System.out.println("No se logro conectarse a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='style.css'>");
            out.println("<title>Servlet SubirDesc</title>");            
            out.println("</head>");
            out.println("<body>");
            int id_ruta=Integer.parseInt(request.getParameter("idr"));
            String desc=request.getParameter("desc");
            try{
                String q="insert into descripcion(des_desc,id_ruta) values('"+desc+"',"+id_ruta+");";
                set.executeUpdate(q);
                out.println("<h1 class='encabezado'>Se subio correctamente la descripcion</h1>");
                out.println("<div class='flecha'><a href='Principal.jsp?id="+request.getParameter("usu")+"' ><button class='atras'>Volver a Principal</button></a></div>");
            }catch(Exception e){
                out.println(e.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "SubirDesc";
    }// </editor-fold>

}
