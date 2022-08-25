<%-- 
    Document   : Reg-invitado
    Created on : 19/05/2022, 03:28:50 AM
    Author     : M3R-00
--%>

<%@page contentType="text/html" language="java" import="java.sql.*, java.util.*, java.text.*, Control.Conexion" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMAP</title>
    </head>
    <body>
        <%
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConexion();
            try{ 
                String usu, contra, usuinv = "";
                usu = request.getParameter("usuario");
                contra = request.getParameter("contra");
                set = con.createStatement();
                String m = "select * from usuario where id_usuario ='"+usu+"'";
                rs = set.executeQuery(m);
                while(rs.next()){
                    usuinv = rs.getString("id_usuario"); 
                }
                usu = usu.toUpperCase();
                usuinv = usuinv.toUpperCase();
                if(usu.equals(usuinv)){
    %>
                    <script>alert("El usuario ya esta registrado");</script>
                    <meta http-equiv="Refresh" content="0;URL=Reg-invitado.html">
    <%      
                }else{
                    String q = "insert into usuario values('"+usu+"','"+contra+"',3)";
                    int registro = set.executeUpdate(q);
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
    %>
            <script>alert("Error en la base de datos");</script>
            <meta http-equiv="Refresh" content="0;URL=Reg-invitado.html">
    <%
        }
        %>              
    </body>
</html>
