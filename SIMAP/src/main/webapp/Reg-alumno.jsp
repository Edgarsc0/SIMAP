<%-- 
    Document   : Reg
    Created on : 19/05/2022, 12:37:56 AM
    Author     : M3R-00
--%>

<%@page contentType="text/html" language="java" import="java.sql.*, java.util.*, java.text.*, Control.Conexion" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMAP</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <%
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            try{ 
                String bol, contra, gru, nom, appat, apmat, usual = "", idgru = "";
                bol = request.getParameter("boleta");
                contra = request.getParameter("contra");
                gru = request.getParameter("grupo");
                nom = request.getParameter("nombre");
                appat = request.getParameter("appat");
                apmat = request.getParameter("apmat");
                set = con.createStatement();
                String m = "select * from usuario where id_usuario = " +bol;
                rs = set.executeQuery(m);
                while(rs.next()){
                    usual = rs.getString("id_usuario"); 
                }                
                if(bol.equals(usual)){
    %>
                    <script>alert("La boleta ingresada ya esta registrada");</script>
                    <meta http-equiv="Refresh" content="0;URL=Reg-alumno.html">
    <%          
                }
                m = "select * from grupo where grp_grupo = '"+gru+"'";
                rs = set.executeQuery(m);
                while(rs.next()){
                    idgru = rs.getString("id_grupo");
                }
                if(idgru.equals("")){
    %>
                    <script>alert("El grupo ingresado no existe");</script>
                    <meta http-equiv="Refresh" content="0;URL=Reg-alumno.html">
    <%
                }else{
                    String q = "insert into usuario values('"+bol+"','"+contra+"',1)";
                    String p = "insert into nombres(nom_nombre,nom_appat,nom_apmat,id_usuario) values('"+nom+"','"+appat+"','"+apmat+"','"+bol+"')";
                    String r = "insert into pertenece(id_usuario, id_grupo) values ('"+bol+"','"+idgru+"')";
                    int registro = set.executeUpdate(q);
                    int registro2 = set.executeUpdate(p);
                    int registro3 = set.executeUpdate(r);
    %>
                    <script>alert("Registro completo");</script>
                    <meta http-equiv="Refresh" content="0;URL=index.html">
    <% 
                }
            }catch(SQLException ex){
                System.out.println("Error al registrar");
                System.out.println(ex.getMessage());
            }        
        }catch(Exception e){
            System.out.println("Error al conectar BD");
            System.out.println(e.getMessage());
        }
        %>              
    </body>
</html>
