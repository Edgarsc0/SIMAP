<%-- 
    Document   : Log-alumno
    Created on : 19/05/2022, 11:19:06 PM
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
                String bol, contra, usual = "", conalu = "", rol = "";
                bol = request.getParameter("boleta");
                contra = request.getParameter("contra");
                set = con.createStatement();
                String m = "select * from usuario where id_usuario = " +bol;
                rs = set.executeQuery(m);
                while(rs.next()){
                    usual = rs.getString("id_usuario");
                    conalu = rs.getString("usu_password");
                    rol = rs.getString("id_rol");
                }
                if(rol.equals("1")){
                    if(usual.equals(bol) && conalu.equals(contra)){
        %>
                        <meta http-equiv="Refresh" content="0;URL=Principal.jsp?id=<%=bol%>">
        <%
                    }else{
        %>
                        <script>alert("La contraseña ingresada es incorrecta");</script>
                        <meta http-equiv="Refresh" content="0;URL=Log-alumno.html?">
        <%
                    }
                }else{
        %>
                    <script>alert("El usuario ingreasado no es de tipo alumno o no existe");</script>
                    <meta http-equiv="Refresh" content="0;URL=Log-alumno.html?">
        <%
                }
            }catch(SQLException ee){
                System.out.println("Error al rconsultar");
                System.out.println(ee.getMessage());
            }
        }catch(Exception e){
            System.out.println("Error al conectar BD");
            System.out.println(e.getMessage());
        }
        %>
    </body>
</html>
