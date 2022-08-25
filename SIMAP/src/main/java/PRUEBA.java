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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
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
public class PRUEBA extends HttpServlet {
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
            //out.println("<h1>RUTA A: <input type='text' name='destino' readonly='' value='"+parametros+"'></h1>");
            //out.println("<h1>"+request.getParameter("usu")+"</h1>");
            out.println("<!DOCTYPE html>\n" +
"<!--\n" +
"Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license\n" +
"Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template\n" +
"-->\n" +
"<html>\n" +
"    <head>\n" +
"        <title>TODO supply a title</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel='stylesheet' href='style.css?1.0'>\n"+ 
"        <script src=\"https://cdn.plot.ly/plotly-2.12.1.min.js\"></script>\n" +
"    </head>\n" +
"    <body>\n" +
"        <!--<button onclick=\"getLocation()\">Iniciar Ruta</button>-->\n" +
                    "<div class='mainForm'>"+
"        <form class='ser' action=\"EnviarCoor\" method=\"post\">\n" +
                    "<h1>RUTA A: <input type='text' name='destino' readonly='' value='"+parametros.get(1)+"'></h1>"+
"            <div id=\"div\"></div>\n" +
"            <input type='hidden' name='usu' value='"+request.getParameter("usu")+"'>"+
"            <input class='enviar' name='hola' type=\"submit\" value=\"Enviar datos\">\n" +
"        </form>\n" +
        "        <button class='enviar' onclick=\"getLocation()\">Iniciar Ruta</button>\n" +
        "</div>"+
"        <script>\n" +
"            var i=1;\n" +
"            var lat=[];\n" +
"            var lon=[];\n" +
"            var alt=[];\n" +
"            function getLocation(){\n" +
"                if(navigator.geolocation){\n" +
"                    var options={enableHighAccuracy:true,timeout:5000,maximumAge:0};\n"+
"                    globalThis.wp=navigator.geolocation.watchPosition(showPosition,error,options);\n" +
"                    globalThis.button=document.createElement(\"BUTTON\");\n" +
"                    var text=\"Detener Wp()\";\n" +
"                    button.innerHTML=text;\n" +
"                    button.setAttribute(\"onclick\",\"detenerWp()\");\n" +
"                    button.setAttribute(\"id\",\"parar\");\n" +
"                }else{}\n" +
"            }\n" +
"            function detenerWp(){\n" +
"                try{\n" +
"                    navigator.geolocation.clearWatch(wp);\n" +
"                    document.getElementById(\"div\").removeChild(button);\n" +
"                    //document.getElementById(\"div\").removeChild(copiar);\n" +
"                    alert(\"Se logro parar Wp()\");\n" +
"                    //alert(lat+\", \"+lon+\", \"+alt);\n" +
"                }catch(error){\n" +
"                    alert(\"No se logro parar el WatchPosition()\"+error);\n" +
"                }\n" +
"            }\n" +
"            function error(){\n" +
"                alert(\"Error al ejecutar WP()\");\n" +
"            }\n" +
"            corx=[];\n" +
"            cory=[];\n" +
"            function showPosition(position){\n" +
"                var tabla=document.createElement(\"TABLE\");\n" +
"                tabla.setAttribute(\"id\",\"tb\");\n" +
"                tabla.setAttribute(\"style\",\"display:none;\");\n" +
"                //tabla.setAttribute(\"border\",\"1\");\n" +
"                var fila_col=\"<tr><td>\"+i+\": </td>\\n\\\n" +
"                <td>\\n\\\n" +
"                    <input type='hidden' style='border:0;' name='longitud-\"+i+\"' id='longitud-\"+i+\"' readonly='' value='\"+position.coords.longitude.toFixed(13)+\"'>\\n\\\n" +
"                </td>\\n\\\n" +
"                <td>\\n\\\n" +
"                    <input type='hidden' style='border:0;' name='latitud-\"+i+\"' readonly='' id='latitud-\"+i+\"' value='\"+position.coords.latitude.toFixed(13)+\"'>\\n\\\n" +
"                </td>\\n\\\n" +
"                <td>\\n\\\n" +
"                    <input type='hidden' readonly='' name='altura-\"+i+\"' id='altura-\"+i+\"' value='\"+position.coords.altitude+\"'>\\n\\\n" +
"                </td>\\n\\\n" +
"                </tr>\";\n" +
"                /*if(position.coords.altitude<2243){\n" +
"                    piso=\"<td>Estas en planta baja</td></tr>\";\n" +
"                }if(position.coords.altitude>=2243 && position.coords.altitude<2246){\n" +
"                    piso=\"<td>Estas en el primer piso</td></tr>;\"\n" +
"                }if(position.coords.altitude>=2246 && position.coords.altitude<2249){\n" +
"                    piso=\"<td>Estas en el segundo piso</td></tr>\";\n" +
"                }if(position.coords.altitude>=2249){\n" +
"                    piso=\"<td>Estas en el tercer piso</td></tr>\";\n" +
"                }*/\n" +
"                lat.push(position.coords.latitude.toFixed(13));\n" +
"                lon.push(position.coords.longitude.toFixed(13));\n" +
"                try{alt.push(position.coords.altitude.toFixed(13))}catch(error){alt.push(position.coords.altitude);}\n" +
"                tabla.innerHTML=fila_col;\n" +
"                document.getElementById(\"div\").appendChild(tabla);\n" +
"                i++;\n" +
"                corx.push(position.coords.longitude.toFixed(13));\n" +
"                cory.push(position.coords.latitude.toFixed(13));\n" +
"                //alert(corx+\", \"+cory);\n" +
"                graficar(corx,cory);\n" +
"            } \n" +
"            function graficar(x,y){\n" +
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
"                //var data=[{x:x,y:y},{x:cex,y:cey},{x:ceax,y:ceay},{x:cegx,y:cegy}];\n" +
"                var data=[{x:x,y:y}];\n" +
"                var layout={title:\"Recorrido\",width:600,height:\"600\",yaxis: {fixedrange: true},xaxis :{fixedrange: true}};\n" +
"                Plotly.newPlot(\"gd\",data,layout);\n" +
"            }");
            out.println("</script>");
            try{
                Calendar c2 = new GregorianCalendar();
                String q;
                ArrayList<String> inicio=new ArrayList<>();
                ArrayList<String> finales=new ArrayList<>();
                //int i=0;
                boolean estaOcupado=false;
                int dia =c2.get(Calendar.DAY_OF_WEEK);
                String hora=Integer.toString(c2.get(Calendar.HOUR));
                //String hora="14";
                //out.println("<h1>"+hora+"</h1>");
                out.println("<br>");
                int dia_int=0;
                switch(dia){
                    case 2:
                        dia_int=1;
                        break;
                    case 3:
                        dia_int=2;
                        break;
                    case 4:
                        dia_int=3;
                        break;
                    case 5:
                        dia_int=4;
                        break;
                    case 6:
                        dia_int=5;
                        break;    
                    default:
                        out.println("<h1>El aula esta desocupada</h1>");
                        break;
                }
                switch(parametros.get(1)){
                    case "Aula 4.0":
                        //out.println("<h1>AULA 4.0</h1>");
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el primer piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        break;
                    case "Aula samsung":
                        //out.println("<h1>AULA SAMSUNG</h1>");
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el segundo piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        break;
                    case "Laboratorio de base de datos":
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        //out.println("<h1>LBD</h1>");
                        out.println("<h1>Dirigete hacia el segundo piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        break;
                    case "Laboratorio de Biologia":
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el segundo piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        //out.println("<h1>LAB BIOLOGIA</h1>");
                        break;
                    case "Laboratorio de Desarrollo de Software":
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el segundo piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        //out.println("<h1>LDS</h1>");
                        break;
                    case "Laboratorio de Nuevas Tecnologias":
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"';";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el segundo piso</h1>");
                        out.println("<h1>El laboratorio se ubica en el edificio derecho con vista a Mexico - Tacuba</h1>");
                        //out.println("<h1>LNT</h1>");
                        break;
                    case "Salon 13":
                        q="select hor_hora_inicio, hor_hora_final from horario where id_dia="+dia_int+" and sal_nombre='"+parametros.get(1)+"'";
                        set=con.createStatement();
                        rs=set.executeQuery(q);
                        while(rs.next()){
                            inicio.add(rs.getString("hor_hora_inicio"));
                            finales.add(rs.getString("hor_hora_final"));
                        }
                        for(int i=0;i<inicio.size();i++){
                            if(Integer.parseInt(inicio.get(i).split(":")[0])<=Integer.parseInt(hora) && Integer.parseInt(finales.get(i).split(":")[0])>Integer.parseInt(hora)){
                                estaOcupado=true;
                                break;
                            }else{
                                estaOcupado=false;
                            }
                        }
                        if(estaOcupado==true){
                            out.println("<h1>El salon se encuentra en uso</h1>");
                        }else{
                            out.println("<h1>El salon no se encuentra en uso</h1>");
                        }
                        out.println("<h1>Dirigete hacia el segundo piso.</h1>");
                        out.println("<h1>El salon se ubica en el edificio izquierdo, el mas proximo al edificio de gobierno</h1>");
                        //out.println("<h1>SALON 13</h1>");
                        break;
                    default:
                        out.println("<h1>Lo sentimos, nuevos horarios se subiran pronto a la base de datos.</h1>");
                        //out.println("<h1>"+parametros.get(1)+"</h1>");
                        break;
                }
            }catch(Exception e){
                out.println("<h1>"+e.getMessage()+"</h1>");
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
        return "PRUEBA";
    }// </editor-fold>

}
