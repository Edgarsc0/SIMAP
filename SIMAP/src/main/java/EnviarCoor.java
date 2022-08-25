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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esanc
 */
public class EnviarCoor extends HttpServlet {
    ArrayList<Double> longitudes=new ArrayList<>();
    ArrayList<Double> latitudes=new ArrayList<>();
    ArrayList<Double> alturas=new ArrayList<>();
    DecimalFormat df=new DecimalFormat("#.0000000000");
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
            out.println("<title>Servlet prueba</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 class='encabezado'>ENVIO DE COORDENADAS</h1>");
            //out.println("<h1>"+request.getParameter("longitud-1")+"</h1>");
            int i=1;
            longitudes.clear();
            latitudes.clear();
            alturas.clear();
            do{
                longitudes.add(Double.parseDouble(request.getParameter("longitud-"+i)));
                latitudes.add(Double.parseDouble(request.getParameter("latitud-"+i)));
                //out.println("<h1>"+request.getParameter("altura-"+i).equals("null")+"</h1>");
                if(request.getParameter("altura-"+i).equals("null")){
                    
                }else{
                    alturas.add(Double.parseDouble(request.getParameter("altura-"+i)));
                }
                //out.println("<h1>"+request.getParameter("longitud-"+i)+"</h1>");
                //out.println("<h1>"+request.getParameter("latitud-"+i)+"</h1>");
                i++;
            }while(request.getParameter("longitud-"+i)!=null);
            //out.println("<h1>"+longitudes+"</h1>");
            //out.println("<h1>"+latitudes+"</h1>");
            //out.println("<h1>"+alturas+"</h1>");
            try{
                String origen;
                if(isInEscuela()==true){
                    if(isInEdifAulas()==true){
                        origen="EdifAulas";
                    }else if(isInEdifGob()==true){
                        origen="EdifGob";
                    }else{
                        origen="AreaComun";
                    }
                }else{
                    origen="Externo";
                }
                String destino=request.getParameter("destino");
                Calendar c2 = new GregorianCalendar();
                String dia = Integer.toString(c2.get(Calendar.DATE));
                String mes = Integer.toString(c2.get(Calendar.MONTH));
                String annio = Integer.toString(c2.get(Calendar.YEAR));
                String hora=Integer.toString(c2.get(Calendar.HOUR))+":"+Integer.toString(c2.get(Calendar.MINUTE));
                String usuario=request.getParameter("usu");
                //out.println("<h1>"+usuario+"</h1>");
                String q1="insert into ruta(rut_origen,rut_destino,rut_dia,rut_mes,rut_anno,rut_hora,id_usuario) values ('"+origen+"','"+destino+"','"+dia+"','"+mes+"','"+annio+"','"+hora+"','"+usuario+"');";
                set.executeUpdate(q1);
                //out.println("SE SUBIO EL REGISTRO A 'RUTA'");
                try{
                    int id_ruta=0;
                    String q2="select id_ruta from ruta where rut_origen='"+origen+"' and rut_destino='"+destino+"' and rut_dia='"+dia+"' and rut_mes='"+mes+"' and rut_anno='"+annio+"' and rut_hora='"+hora+"' and id_usuario='"+usuario+"';";
                    set=con.createStatement();
                    rs=set.executeQuery(q2);
                    while(rs.next()){
                        id_ruta=rs.getInt("id_ruta");
                    }
                    //out.println("<h1>"+id_ruta+"</h1>");
                    //out.println(id_ruta);
                    if(alturas.size()==0){
                        for(int j=0;j<=longitudes.size()-1;j++){
                            String q3="insert into coordenadas(cor_lat,cor_lon,cor_alt,id_ruta) values("+latitudes.get(j)+","+longitudes.get(j)+",null,"+id_ruta+");";
                            set.executeUpdate(q3);
                            //out.println("<h1>Se ejecuto</h1>");
                        }   
                    }else{
                       for(int j=0;j<=longitudes.size()-1;j++){
                            String q3="insert into coordenadas(cor_lat,cor_lon,cor_alt,id_ruta) values("+latitudes.get(j)+","+longitudes.get(j)+","+alturas.get(j)+","+id_ruta+");";
                            set.executeUpdate(q3);
                            //out.println("<h1>Se ejecuto</h1>");
                        }    
                    }
                    out.println("<form class='mainForm' action='SubirDesc' method='post'>");
                    out.println("<h1>¿Deseas agregar una descripcion a la ruta?</h1>");
                    out.println("<input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>");
                    out.println("<textarea class='sere' name='desc'></textarea>");
                    out.println("<input type='hidden' name='idr' value='"+id_ruta+"'>");
                    out.println("<input class='enviar' type='submit' value='Subir Descripcion'>");
                    out.println("</form>");
                    out.println("<div class='flecha'><a href='Principal.jsp?id="+usuario+"'><button class='atras'>Volver a Principal</button></a></div>");
                }catch(Exception e){
                    out.println("NO SE LOGRO SUBIR LAS COORDENADADAS A 'COORDENADAS'");
                    out.println(e.getMessage());
                }
            }catch(Exception e){
                out.println("NO SE LOGRO SUBIR EL REGISTRO A 'RUTA'");
                out.println(e.getMessage());
            }
            //out.println("<h1>"+request.getParameter("hola")+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public double calcularArea(double px[],double py[]){
        double suma1=0;
        for(int i=0;i<px.length-1;i++){
            suma1+=px[i]*py[i+1];
        }
        double suma2=0;
        for(int i=0;i<px.length-1;i++){
            suma2+=px[i+1]*py[i];
        }
        return Math.abs(0.5*(suma1-suma2));
    }
    public boolean isInEscuela(){
        double cex[]={-99.17541532539201,-99.17512231414875,-99.17461031579097,-99.17521735036371,-99.17602737788347,-99.17541532539201};
        double cey[]={19.454336741401818,19.454072754761494,19.453320275824684,19.45287151199291,19.453431073536365,19.454336741401818};
        double clientx=longitudes.get(0);
        double clienty=latitudes.get(0);
        //No esta dentro de la escuela: 19.454259961540153, -99.17455366690409
        //Este si esta 19.45350277323454, -99.17515874926578
        //19.453032021309095, -99.17524526704673
        //19.453444141554776, -99.17517601478276
        //19.453545182248305, -99.17584836274122
        //double clientx= -99.17584836274122;
        //double clienty=19.453545182248305;
        double area_poligono=calcularArea(cex,cey);
        double area_total=0;
        for(int i=0;i<5;i++){
            double trix[]={cex[i],cex[i+1],clientx,cex[i]};
            double triy[]={cey[i],cey[i+1],clienty,cey[i]};
            area_total+=calcularArea(trix,triy);
        }
        return df.format(area_poligono).equals(df.format(area_total));
    }
    public boolean isInEdifAulas(){
        double ceax[]={-99.17544652013044,-99.17595448028152,-99.17569611465676,-99.17518177457127,-99.17544652013044};
        double ceay[]={19.453207518417145,19.453519557636113,19.45389325323486,19.453584221305192,19.453207518417145};
        //Este punto esta dentro del edif aulas: 19.453531869930085, -99.17566578790624
        //19.453538029065584, -99.17559716886538
        //double clientx=-99.17584836274122;
        //double clienty=19.453545182248305;
        double clientx=longitudes.get(0);
        double clienty=latitudes.get(0);
        double area_poligono=calcularArea(ceax,ceay);
        double area_total=0;
        for(int i=0;i<4;i++){
            double trix[]={ceax[i],ceax[i+1],clientx,ceax[i]};
            double triy[]={ceay[i],ceay[i+1],clienty,ceay[i]};
            area_total+=calcularArea(trix,triy);
        }
        return df.format(area_poligono).equals(df.format(area_total));
    }
    public boolean isInEdifGob(){
        double ceax[]={-99.17532844482236,-99.17559063093498,-99.17542634570286,-99.17516483006723,-99.17532844482236};
        double ceay[]={19.45380788954552,19.453967853726997,19.45420811638694,19.454047519898072,19.45380788954552};
        //19.453727592505093, -99.17520636041951
        //double clientx=-99.17520636041951;
        //double clienty=19.453727592505093;
        double clientx=longitudes.get(0);
        double clienty=latitudes.get(0);
        double area_poligono=calcularArea(ceax,ceay);
        double area_total=0;
        for(int i=0;i<4;i++){
            double trix[]={ceax[i],ceax[i+1],clientx,ceax[i]};
            double triy[]={ceay[i],ceay[i+1],clienty,ceay[i]};
            area_total+=calcularArea(trix,triy);
        }
        return df.format(area_poligono).equals(df.format(area_total));
    }
    public boolean isInAreaComun(){
        if(isInEscuela()==false){
            return false;
        }else{
            if(isInEdifAulas()==false && isInEdifGob()==false){
                return true;
            }else{
                return false;
            }
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "EnviarCoor";
    }// </editor-fold>

}
