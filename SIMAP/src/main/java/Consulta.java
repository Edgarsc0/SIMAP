/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Alumno
 */
public class Consulta extends HttpServlet {
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
            out.println("<title>Servlet Consulta</title>");   
            out.println("<link rel='stylesheet' href='style.css?1.0'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='encabezado'>");
            out.println("<h1>Consulta de Rutas</h1>");
            out.println("</div>");
            String usu=request.getParameter("usu");
            //out.println("<h1>"+usu+"</h1>");
            int i=1;
            out.println("<div class='mainForm'>");
            out.println("<table border='1' class='cons'>"
                    + "<tr>"
                    + "<th>Id</th>"
                    + "<th>Origen</th>"
                    + "<th>Destino</th>"
                    + "<th>Dia</th>"
                    + "<th>Mes</th>"
                    + "<th>Año</th>"
                    + "<th>Hora</th>"
                    + "<th></th>"
                    + "</tr>");
            try{
                String origen,destino,dia,mes,año,hora;
                String q="select rut_origen,rut_destino,rut_dia,rut_mes,rut_anno,rut_hora from ruta where id_usuario='"+usu+"';";
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    origen=rs.getString("rut_origen");
                    destino=rs.getString("rut_destino");
                    dia=rs.getString("rut_dia");
                    mes=rs.getString("rut_mes");
                    año=rs.getString("rut_anno");
                    hora=rs.getString("rut_hora");
                    out.println("<form action='MostrarGrafica' method='post'>");
                    out.println("<tr>"
                            + "<td>"+i+"</td>"
                            + "<td><input type='text' name='origen-"+i+"' value='"+origen+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='text' name='destino-"+i+"' value='"+destino+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='text' name='dia-"+i+"' value='"+dia+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='text' name='mes-"+i+"' value='"+mes+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='text' name='anno-"+i+"' value='"+año+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='text' name='hora-"+i+"' value='"+hora+"' readonly='' style='border:0;'></td>"
                            + "<td><input type='submit' value='Mostrar Recorrido'></td>"
                            + "</tr>");
                    out.println("</form>");
                    i++;
                }
                out.println("</table>");
                out.println("</div>");
            }catch(Exception e){
                
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
        return "Consulta";
    }// </editor-fold>

}
