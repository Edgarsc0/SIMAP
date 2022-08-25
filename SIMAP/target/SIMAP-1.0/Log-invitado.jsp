<%-- 
    Document   : Log-invitado
    Created on : 29/05/2022, 04:29:16 PM
    Author     : M3R-00
--%>

<%@page contentType="text/html" import="java.sql.*, java.util.*, java.text.*, Control.Conexion" pageEncoding="UTF-8"%>
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
                String usu, contra, usuinv = "", coninv = "", rol = "";
                usu = request.getParameter("usu");
                contra = request.getParameter("contra");
                set = con.createStatement();
                String m = "select * from usuario where id_usuario = '"+usu+"'";
                rs = set.executeQuery(m);
                while(rs.next()){
                    usuinv = rs.getString("id_usuario");
                    coninv = rs.getString("usu_password");
                    rol = rs.getString("id_rol");
                }
                usu = usu.toUpperCase();
                usuinv = usuinv.toUpperCase();
                if(rol.equals("3")){
                    if(usuinv.equals(usu) && coninv.equals(contra)){
        %>
                        <meta http-equiv="Refresh" content="0;URL=Principal.jsp?id=<%=usu%>">
        <%
                    }else{
        %>
                        <script>alert("La contraseña ingresada es incorrecta");</script>
                        <meta http-equiv="Refresh" content="0;URL=Log-invitado.html?">
        <%
                    }
                }else{
        %>
                    <script>alert("El usuario ingresado no es de tipo invitado o no existe");</script>
                    <meta http-equiv="Refresh" content="0;URL=Log-invitado.html?">
        <%
                }
            }catch(SQLException ee){
                System.out.println("Error al consultar");
                System.out.println(ee.getMessage());
            }
        }catch(Exception e){
            System.out.println("Error al conectar BD");
            System.out.println(e.getMessage());
        }
        %>
    </body>
</html>
