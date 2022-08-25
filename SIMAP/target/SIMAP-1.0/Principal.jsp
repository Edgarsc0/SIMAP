<%-- 
    Document   : Principal
    Created on : 19/05/2022, 11:07:18 PM
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
        <div class="encabezado1">
        <%
        Connection con = null;
        Statement set = null;
        ResultSet rs = null;
        String id = request.getParameter("id");
        try{
            con = Conexion.getConexion();
            try{
                set=con.createStatement();
                String q = "select * from usuario where id_usuario = '"+id+"'";
                rs = set.executeQuery(q);
                int rol = 0;
                while(rs.next()){
                   rol = rs.getInt("id_rol");
                }
                if(rol == 1){
                    q = "select * from nombres where id_usuario = '"+id+"'";             
                    rs = set.executeQuery(q);
                    while(rs.next()){                    
        %>
            <div class="menu">
                <button onclick="BotonDes()" class="drop-button"></button>
                <div id="myDropdown" class="dropdown-content">
                    <div class="foto">
                            
                    </div>
                    <div class="menudat1">
                       <label class="d1">Nombre: <%=rs.getString("nom_nombre")%></label> 
                    </div>
                    <div class="menudat2">
                       <label class="d2">Apellidos: <%=rs.getString("nom_appat")%> <%=rs.getString("nom_apmat")%></label> 
                    </div>
        <%
                    }
                    q = "select * from pertenece inner join grupo on pertenece.id_grupo = grupo.id_grupo where id_usuario ="+id;
                    rs = set.executeQuery(q);
                    while(rs.next()){
        %>
                    <div class="menudat1">
                        <label class="d1">Grupo: <%=rs.getString("grp_grupo")%></label> 
                    </div>
                    <div class="menudat2">
                        <button class="BC" id="BC" onclick="redirigirCER(id)">Cerrar Sesion</button>
                    </div>                
                </div>
            </div>
        <%      
                    }
                }
                if(rol == 2){
        %>
            <div class="menu">
                <button onclick="BotonDes()" class="drop-button"></button>
                <div id="myDropdown" class="dropdown-content">
                    <div class="foto">
                            
                    </div>
                    <div class="menudat1">
                       <label class="d1">Nombre: </label> 
                    </div>
                    <div class="menudat2">
                       <label class="d2">Apellidos: </label> 
                    </div>
                    <div class="menudat1">
                        <label class="d1">:)</label> 
                    </div>
                    <div class="menudat2">
                        <button class="BC" id="BC" onclick="redirigirCER(id)">Cerrar Sesion</button>
                    </div>                
                </div>
            </div>
        <%          
                }
                if(rol == 3){
                    q = "select * from usuario where id_usuario = '"+id+"'";             
                    rs = set.executeQuery(q);
                    while(rs.next()){
        %>
            <div class="menu">
                <button onclick="BotonDes()" class="drop-button"></button>
                <div id="myDropdown" class="dropdown-content">
                    <div class="foto">
                            
                    </div>
                    <div class="menudat1">
                       <label class="d1">INVITADO</label> 
                    </div>
                    <div class="menudat2">
                       <label class="d2">Usuario: <%=rs.getString("id_usuario")%></label> 
                    </div>
                    <div class="menudat1">
                        <label class="d1">:)</label> 
                    </div>
                    <div class="menudat2">
                        <button class="BC" id="BC" onclick="redirigirCER(id)">Cerrar Sesion</button>
                    </div>                
                </div>
            </div>
        <%         
                    }
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
            <div class="titulo">
                <h1>SIMAP</h1>  
            </div>                
        </div>
        <div class="main">
       <% 
        try{
            id = request.getParameter("id");
        %>
            <div class="imgp" style="margin-right:10px;">
                <button class="imgE" id="ConF" onclick="window.location.href='Con-espacios.jsp?id=<%=id%>'"></button>
            </div>
            <div class="encabezado2">
                <p class="p2">Consultar Espacios Fisicos</p></div>
        </div>
        <form action='Consulta' method="post">
            <div class="main">
                <div class="encabezado2">
                    <p class="p2">Consultar Ruta</p>
                </div>
                <div class="imgp" style="margin-left:10px;">
                    <!--<input type="text" placeholder="Escribe tus credenciales de usuario" name="usu">-->
                    <input type="submit" name='usu' class="imgC" id="ConR" value='<%=id%>'>
                </div>
            </div>
        </form>
                        <%
        }catch(Exception e){

        } 
        %>
        <script src="ac.js"></script>
    </body>
</html>
