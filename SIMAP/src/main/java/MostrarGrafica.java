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
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class MostrarGrafica extends HttpServlet {
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
            out.println("<link rel='stylesheet' href='style.css?1.0'>");
            out.println("<script src=\"https://cdn.plot.ly/plotly-2.12.1.min.js\"></script>");
            out.println("<title>Servlet MostrarGrafica</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='encabezado'>MOSTRAR GRAFICA</h1>");
            Enumeration en=request.getParameterNames();
            ArrayList<String> parametros=new ArrayList<>();
            ArrayList<String> values=new ArrayList<>();
            while(en.hasMoreElements()){
                Object objOri=en.nextElement();
                String param=(String)objOri;
                String value=request.getParameter(param);
                parametros.add(param);
                values.add(value);
                //out.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
            }
            //out.println("<script>");
            try{
                int id_ruta=0;
                String q="select id_ruta from ruta where rut_origen='"+values.get(0)+"' and rut_destino='"+values.get(1)+"' and rut_dia='"+values.get(2)+"' and rut_mes='"+values.get(3)+"' and rut_anno='"+values.get(4)+"'and rut_hora='"+values.get(5)+"';";
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    id_ruta=rs.getInt("id_ruta");
                }
                //out.println("<h1>"+id_ruta+"</h1>");
                try{
                    ArrayList<Double> longitudes=new ArrayList<>();
                    ArrayList<Double> latitudes=new ArrayList<>();
                    String q2="select cor_lat,cor_lon from coordenadas where id_ruta="+id_ruta;
                    set=con.createStatement();
                    rs=set.executeQuery(q2);
                    while(rs.next()){
                            longitudes.add(rs.getDouble("cor_lon"));
                            latitudes.add(rs.getDouble("cor_lat"));
                        }
                    //out.println("<h1>"+longitudes+"</h1>");
                    //out.println("<h1>"+latitudes+"</h1>");
                    out.println("<script>");
                    out.println("var px=[];"
                            + "var py=[];");
                    for(int i=0;i<=longitudes.size()-1;i++){
                        out.println("px.push("+longitudes.get(i)+");");
                        out.println("py.push("+latitudes.get(i)+")");
                    }
                    out.println("function graficar(x,y){\n" +
        "                var newDiv = document.createElement(\"div\");\n" +
        "                newDiv.setAttribute(\"id\",\"gd\");\n" +
        "                document.body.appendChild(newDiv);\n" +
        "                cex=[-99.17541532539201,-99.17512231414875,-99.17461031579097,-99.17521735036371,-99.17602737788347,-99.17541532539201];\n" +
        "                cey=[19.454336741401818,19.454072754761494,19.453320275824684,19.45287151199291,19.453431073536365,19.454336741401818]; \n" +
        "                ceax=[-99.1756954746791,-99.17518183576605,-99.17523749159493,-99.17534746221106,-99.17537428426803,-99.1754440217851,\n" +
        "                -99.17545810334578,-99.17528375970011,-99.17544670389499,-99.17595632375087,-99.17579606199205,-99.17556472109659,\n" +
        "                -99.1755508731297,-99.17561433763215,-99.17559153882097,-99.17552582476449,-99.17551576646892,-99.1757383900352,-99.1756954746791];\n" +
        "                ceay=[19.453892195944235,19.453584552325598,19.453505518363585,19.45357190682758,19.453533338228258,19.453572538994447,\n" +
        "                19.453552306369573,19.453444188006618,19.453208982651297,19.453517531139237,19.453747678376818,19.453607314116777,\n" +
        "                19.45362774630948,19.453667739635584,19.453701250024466,19.453660784619444,19.453681649569084,19.453830233305336,19.453892195944235];\n" +
        "                cegx=[-99.17532798981556,-99.17516504536202,-99.17542600216802,-99.17543002548388,-99.1754675764514,-99.1755138445508,-99.17547562303848,-99.17559151690027,-99.17532798981556];\n" +
        "                cegy=[19.453808974780536,19.45404797281946,19.454208614587117,19.45420355642922,19.454226950396784,19.454163723411376,19.454140329457825,19.453967042237146,19.453808974780536];\n" +
        "                var data=[{x:x,y:y},{x:cex,y:cey},{x:ceax,y:ceay},{x:cegx,y:cegy}];\n" +
        "                //var data=[{x:x,y:y}];\n" +
        "                var layout={title:\"Recorrido\",width:600,height:\"600\",yaxis: {fixedrange: true},xaxis :{fixedrange: true}};\n" +
        "                Plotly.newPlot(\"gd\",data,layout);\n" +
        "            }");
                    if(longitudes.size()==0){
                        out.println("alert('No hay registro de esta ruta');");
                    }else{
                        out.println("graficar(px,py);");
                    }
                    /*out.println("if(px.length==0){"
                            + "alert('No hay registro')}else{;"
                            + "graficar(px,py);"
                            + "alert('Podras descargar la ruta en formato png.')}");*/
                    out.println("</script>");
                    try{
                        String q3="select des_desc from descripcion where id_ruta="+id_ruta;
                        String descripcion;
                        set=con.createStatement();
                        rs=set.executeQuery(q3);
                        while(rs.next()){
                            descripcion=rs.getString("des_desc");
                            out.println("<textarea class='se' readonly=''>"+descripcion+"</textarea>");
                        }
                    }catch(Exception e){
                        out.println("<h1>"+e.getMessage()+"</h1>");
                    }
                }catch(Exception e){
                    out.println("<h1>"+e.getMessage()+"</h1>");
                }
            }catch(Exception e){
                out.println("<h1>No se pudo obtener el dato</h1>");
                out.println(e.getMessage());
            }
            //out.println("<h1>"+parametros+"</h1>");
            //out.println("<h1>"+values+"</h1>");
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
        return "MostrarGrafica";
    }// </editor-fold>

}
