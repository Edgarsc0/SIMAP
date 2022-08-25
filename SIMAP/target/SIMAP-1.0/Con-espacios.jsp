<%-- 
    Document   : Con-espacios
    Created on : 21/05/2022, 11:53:52 PM
    Author     : M3R-00
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMAP</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <div class="cef">
            <div class="encabezado">
                <h1>CONSULTAR ESPACIOS FISICOS</h1>
            </div>
            <div class="opc">
                <select id="Edi" class="sec2" onchange="cambioEdificio()">
                    <option value="1">Edificio de aulas</option>
                    <option value="2">Edificio de oficinas</option>
                    <option value="3">Espacios libres</option>
                </select>
                <select id="numPiso" class="sec2" onchange="cambioPiso()">
                    <option id="pb" value="0" selected>PLANTA BAJA</option>
                    <option id="p1" value="1">PISO 1</option>
                    <option id="p2" value="2">PISO 2</option>
                    <option id="p3" value="3">PISO 3</option>
                </select>
            </div>
            <%                String id = request.getParameter("id"); %>
            <div id="muestra" class="pb">
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B1" class="B1" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B2" class="B2" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B3" class="B3" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B4" class="B4" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B5" class="B5" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B6" class="B6" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B7" class="B7" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B8" class="B8" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B9" class="B9" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B10" class="B10" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B11" class="B11" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B12" class="B12" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B13" class="B13" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B14" class="B14" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B15" class="B15" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B16" class="B16" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B17" class="B17" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B18" class="B18" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B19" class="B19" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B20" class="B20" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B21" class="B21" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B22" class="B22" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B23" class="B23" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B24" class="B24" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B25" class="B25" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B26" class="B26" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B27" class="B27" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B28" class="B28" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B29" class="B29" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B30" class="B30" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B31" class="B31" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B32" class="B32" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B33" class="B33" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B34" class="B34" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B35" class="B35" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B36" class="B36" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B37" class="B37" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B38" class="B38" name="" value=''></form>
                <form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B39" class="B39" name="" value=''></form><form action='PRUEBA' method='post'><input type='hidden' name='usu' value='<%=id%>'><input type='submit' id="B40" class="B40" name="" value=''></form>
            </div>
            <!--<form action="PRUEBA">
            <div class="mainForm">
                    <input type="submit" class="enviar" value="INICIAR RUTA">
            </div>
            </form>-->
            <% 
            try{ 
            %>
            <div class="flecha">
                <a href="Principal.jsp?id=<%=id%>"><button class="atras">ATRAS</button></a>
            </div>
            <%
            }catch(Exception e){

            } 
            %>
        </div>
        <!--<script src="ac.js"></script>-->
        <script>
            document.getElementById("B1").setAttribute("name", "Salon de usos multiples");
            document.getElementById("B2").setAttribute("name", "Papeleria");
            document.getElementById("B3").setAttribute("name", "Cubiculos de Ingles");
            document.getElementById("B4").setAttribute("name", "Prefectura");
            document.getElementById("B5").setAttribute("name", "Control de asistencia");
            document.getElementById("B6").setAttribute("name", "Impresiones");
            document.getElementById("B7").setAttribute("name", "Cubiculo de matematicas");
            document.getElementById("B8").setAttribute("name", "Servicios generales");
            document.getElementById("B9").setAttribute("name", "Matematicas");
            document.getElementById("B10").setAttribute("name", "Orientacion juvenil");
            document.getElementById("B11").setAttribute("name", "Cubiculo");
            document.getElementById("B12").setAttribute("name", "Oficina");
            document.getElementById("B13").setAttribute("name", "UDI");
            document.getElementById("B14").setAttribute("name", "Oficina");
            document.getElementById("B15").setAttribute("name", "Matematicas basicas");
            document.getElementById("B16").setAttribute("name", "Matematicas");
            document.getElementById("B17").setAttribute("name", "Departamento pedagogico y desarrollo dosente");
            document.getElementById("B18").setAttribute("name", "Batiz virtual");
            document.getElementById("B19").setAttribute("name", "Baños mujeres");
            document.getElementById("B20").setAttribute("name", "Baños hombres");
            document.getElementById("B21").setAttribute("name", "Programcaion de sistemas digitales");
            document.getElementById("B22").setAttribute("name", "Laboratorio de aplicacion de sistemas digitales");
            document.getElementById("B23").setAttribute("name", "Jefatura SD");
            document.getElementById("B24").setAttribute("name", "Sala de juntas");
            document.getElementById("B25").setAttribute("name", "Bodega de electronica");
            document.getElementById("B26").setAttribute("name", "Almacen");
            document.getElementById("B27").setAttribute("name", "Almacen");
            document.getElementById("B28").setAttribute("name", "Cubiculo 1");
            document.getElementById("B29").setAttribute("name", "Cubiculo 2");
            document.getElementById("B30").setAttribute("name", "Jefatura y sala de profesores");
            document.getElementById("B31").setAttribute("name", "CHC");
            document.getElementById("B32").setAttribute("name", "Laboratorio de electronica digital 6°");
            document.getElementById("B33").setAttribute("name", "Laboratorio de electronica digital 4°");
            document.getElementById("B34").setAttribute("name", "Laboratorio de electronica");
            document.getElementById("B35").setAttribute("name", "Bodega");
            document.getElementById("B36").setAttribute("name", "Bodega");
            document.getElementById("B37").setAttribute("name", "Autodesc");
            document.getElementById("B38").setAttribute("name", "Metrologia");
            document.getElementById("B39").setAttribute("name", "Hidroneumatico");
            document.getElementById("B40").setAttribute("name", "Electrico");
            function cambioPiso(){
                var p = document.getElementById("numPiso").value;
                //alert(p);
                //var p=1;
                if(p == 0){
                    document.getElementById("muestra").className = "pb";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Salon de usos multiples");
                    document.getElementById("B2").setAttribute("name", "Papeleria");
                    document.getElementById("B3").setAttribute("name", "Cubiculos de Ingles");
                    document.getElementById("B4").setAttribute("name", "Prefectura");
                    document.getElementById("B5").setAttribute("name", "Control de asistencia");
                    document.getElementById("B6").setAttribute("name", "Impresiones");
                    document.getElementById("B7").setAttribute("name", "Cubiculo de matematicas");
                    document.getElementById("B8").setAttribute("name", "Servicios generales");
                    document.getElementById("B9").setAttribute("name", "Matematicas");
                    document.getElementById("B10").setAttribute("name", "Orientacion juvenil");
                    document.getElementById("B11").setAttribute("name", "Cubiculo");
                    document.getElementById("B12").setAttribute("name", "Oficina");
                    document.getElementById("B13").setAttribute("name", "UDI");
                    document.getElementById("B14").setAttribute("name", "Oficina");
                    document.getElementById("B15").setAttribute("name", "Matematicas basicas");
                    document.getElementById("B16").setAttribute("name", "Matematicas");
                    document.getElementById("B17").setAttribute("name", "Departamento pedagogico y desarrollo dosente");
                    document.getElementById("B18").setAttribute("name", "Batiz virtual");
                    document.getElementById("B19").setAttribute("name", "Baños mujeres");
                    document.getElementById("B20").setAttribute("name", "Baños hombres");
                    document.getElementById("B21").setAttribute("name", "Programcaion de sistemas digitales");
                    document.getElementById("B22").setAttribute("name", "Laboratorio de aplicacion de sistemas digitales");
                    document.getElementById("B23").setAttribute("name", "Jefatura SD");
                    document.getElementById("B24").setAttribute("name", "Sala de juntas");
                    document.getElementById("B25").setAttribute("name", "Bodega de electronica");
                    document.getElementById("B26").setAttribute("name", "Almacen");
                    document.getElementById("B27").setAttribute("name", "Almacen");
                    document.getElementById("B28").setAttribute("name", "Cubiculo 1");
                    document.getElementById("B29").setAttribute("name", "Cubiculo 2");
                    document.getElementById("B30").setAttribute("name", "Jefatura y sala de profesores");
                    document.getElementById("B31").setAttribute("name", "CHC");
                    document.getElementById("B32").setAttribute("name", "Laboratorio de electronica digital 6°");
                    document.getElementById("B33").setAttribute("name", "Laboratorio de electronica digital 4°");
                    document.getElementById("B34").setAttribute("name", "Laboratorio de electronica");
                    document.getElementById("B35").setAttribute("name", "Bodega");
                    document.getElementById("B36").setAttribute("name", "Bodega");
                    document.getElementById("B37").setAttribute("name", "Autodesc");
                    document.getElementById("B38").setAttribute("name", "Metrologia");
                    document.getElementById("B39").setAttribute("name", "Hidroneumatico");
                    document.getElementById("B40").setAttribute("name", "Electrico");
                }
                if(p == 1){
                    document.getElementById("muestra").className = "piso1";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Salon 21");
                    document.getElementById("B2").setAttribute("name", "Salon 20");
                    document.getElementById("B3").setAttribute("name", "Salon 19");
                    document.getElementById("B4").setAttribute("name", "Salon 18");
                    document.getElementById("B5").setAttribute("name", "Salon 17");
                    document.getElementById("B6").setAttribute("name", "Taller de artes visuales");
                    document.getElementById("B7").setAttribute("name", "Salon 16");
                    document.getElementById("B8").setAttribute("name", "Salon 15");
                    document.getElementById("B9").setAttribute("name", "Salon 24");
                    document.getElementById("B10").setAttribute("name", "Baños mujeres");
                    document.getElementById("B11").setAttribute("name", "Baños hombres");
                    document.getElementById("B12").setAttribute("name", "Salon de computacion I");
                    document.getElementById("B13").setAttribute("name", "Salon 23");
                    document.getElementById("B14").setAttribute("name", "Salon 22");
                    document.getElementById("B15").setAttribute("name", "Laboratorio de ingles");
                    document.getElementById("B16").setAttribute("name", "Aula 4.0");
                }
                if(p == 2){
                    document.getElementById("muestra").className = "piso2";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Salon 14");
                    document.getElementById("B2").setAttribute("name", "Salon 13");
                    document.getElementById("B3").setAttribute("name", "Salon 12");
                    document.getElementById("B4").setAttribute("name", "Salon 11");
                    document.getElementById("B5").setAttribute("name", "Salon 10");
                    document.getElementById("B6").setAttribute("name", "Bodega");
                    document.getElementById("B7").setAttribute("name", "Salon 09");
                    document.getElementById("B8").setAttribute("name", "Salon 08");
                    document.getElementById("B9").setAttribute("name", "Dibujo II");
                    document.getElementById("B10").setAttribute("name", "Baños mujeres");
                    document.getElementById("B11").setAttribute("name", "Baños hombres");
                    document.getElementById("B12").setAttribute("name", "Laboratorio de base de datos");
                    document.getElementById("B13").setAttribute("name", "Laboratorio de Nuevas Tecnologias");
                    document.getElementById("B14").setAttribute("name", "Jefatura");
                    document.getElementById("B15").setAttribute("name", "Laboratorio de Desarrollo de Software");
                    document.getElementById("B16").setAttribute("name", "Laboratorio de Biologia");
                    document.getElementById("B17").setAttribute("name", "Cubiculo");
                    document.getElementById("B18").setAttribute("name", "Aula samsung");
                    document.getElementById("B19").setAttribute("name", "Cubiculo de profesores");
                    document.getElementById("B20").setAttribute("name", "Cubiculo programacion");
                }
                if(p == 3){
                    document.getElementById("muestra").className = "piso3";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Salon 7");
                    document.getElementById("B2").setAttribute("name", "Salon 6");
                    document.getElementById("B3").setAttribute("name", "Salon 5");
                    document.getElementById("B4").setAttribute("name", "Salon 4");
                    document.getElementById("B5").setAttribute("name", "Salon 3");
                    document.getElementById("B6").setAttribute("name", "Bodega");
                    document.getElementById("B7").setAttribute("name", "Salon 2");
                    document.getElementById("B8").setAttribute("name", "Salon 1");
                    document.getElementById("B9").setAttribute("name", "Dibujo I");
                    document.getElementById("B10").setAttribute("name", "Baños mujeres");
                    document.getElementById("B11").setAttribute("name", "Baños hombres");
                    document.getElementById("B12").setAttribute("name", "Salon de profesores");
                    document.getElementById("B13").setAttribute("name", "Laboratorio de quimica I");
                    document.getElementById("B14").setAttribute("name", "Cordinacion");
                    document.getElementById("B15").setAttribute("name", "Laboratorio de quimica II");
                    document.getElementById("B16").setAttribute("name", "Cubiculo");
                    document.getElementById("B17").setAttribute("name", "Laboratorio de fisica I y II");
                    document.getElementById("B18").setAttribute("name", "Asesoria");
                    document.getElementById("B19").setAttribute("name", "Laboratorio de fisica III y IV");
                }
                if(p == 11){
                    document.getElementById("muestra").className = "pbof";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Zona de libros");
                    document.getElementById("B2").setAttribute("name", "Zona de dibujo");
                    document.getElementById("B3").setAttribute("name", "Zona de computadoras");
                    document.getElementById("B4").setAttribute("name", "Zona de registro");
                    document.getElementById("B5").setAttribute("name", "Area de lectura");
                    document.getElementById("B6").setAttribute("name", "Cubiculo");
                    document.getElementById("B7").setAttribute("name", "Jefatura");
                    document.getElementById("B8").setAttribute("name", "Sanitario de mujeres");
                    document.getElementById("B9").setAttribute("name", "Sanitario de hombres");
                    document.getElementById("B10").setAttribute("name", "Zona de trofeos");
                    document.getElementById("B11").setAttribute("name", "Servicio medico");
                    document.getElementById("B12").setAttribute("name", "Auditorio");
                    document.getElementById("B13").setAttribute("name", "Oficina del fundador");
                }
                if(p == 22){
                    document.getElementById("muestra").className = "piso1of";
                    //alert(p);
                    document.getElementById("B1").setAttribute("name", "Sala de juntas");
                    document.getElementById("B2").setAttribute("name", "Lenguaje y comunicacion");
                    document.getElementById("B3").setAttribute("name", "Filosofia");
                    document.getElementById("B4").setAttribute("name", "DHP");
                    document.getElementById("B5").setAttribute("name", "Ingles");
                    document.getElementById("B6").setAttribute("name", "Desarrollo personal");
                    document.getElementById("B7").setAttribute("name", "Materia optativa");
                    document.getElementById("B8").setAttribute("name", "Subdireccion");
                    document.getElementById("B9").setAttribute("name", "Denuncia virtual");
                    document.getElementById("B10").setAttribute("name", "Humanisticas");
                    document.getElementById("B11").setAttribute("name", "Sanitario mujeres");
                    document.getElementById("B12").setAttribute("name", "UPIS");
                    document.getElementById("B13").setAttribute("name", "Historia");
                    document.getElementById("B14").setAttribute("name", "Entorno socioeconomico");
                    document.getElementById("B15").setAttribute("name", "Sanitarios mujeres");
                    document.getElementById("B16").setAttribute("name", "Sanitario hombres");
                    document.getElementById("B17").setAttribute("name", "Sanitario hombres");
                    document.getElementById("B18").setAttribute("name", "Direccion");
                    document.getElementById("B19").setAttribute("name", "Subdireccion de extencion");
                    document.getElementById("B20").setAttribute("name", "Subdireccion academica");
                    document.getElementById("B21").setAttribute("name", "Pagaduria");
                    document.getElementById("B22").setAttribute("name", "Zona de ventanillas gestion escolar");
                }
            }  
            function cambioEdificio(){
                var p = document.getElementById("Edi").value;
                if(p == 1){
                    document.getElementById("muestra").className = "pb";
                    document.getElementById("numPiso").className = "sec2";
                    document.getElementById("numPiso").selectedIndex = "0";
                    document.getElementById("pb").value = "0";
                    document.getElementById("p1").value = "1";
                    document.getElementById("p2").className = "";
                    document.getElementById("p3").className = "";
                    document.getElementById("B1").setAttribute("name", "Salon de usos multiples");
                    document.getElementById("B2").setAttribute("name", "Papeleria");
                    document.getElementById("B3").setAttribute("name", "Cubiculos de Ingles");
                    document.getElementById("B4").setAttribute("name", "Prefectura");
                    document.getElementById("B5").setAttribute("name", "Control de asistencia");
                    document.getElementById("B6").setAttribute("name", "Impresiones");
                    document.getElementById("B7").setAttribute("name", "Cubiculo de matematicas");
                    document.getElementById("B8").setAttribute("name", "Servicios generales");
                    document.getElementById("B9").setAttribute("name", "Matematicas");
                    document.getElementById("B10").setAttribute("name", "Orientacion juvenil");
                    document.getElementById("B11").setAttribute("name", "Cubiculo");
                    document.getElementById("B12").setAttribute("name", "Oficina");
                    document.getElementById("B13").setAttribute("name", "UDI");
                    document.getElementById("B14").setAttribute("name", "Oficina");
                    document.getElementById("B15").setAttribute("name", "Matematicas basicas");
                    document.getElementById("B16").setAttribute("name", "Matematicas");
                    document.getElementById("B17").setAttribute("name", "Departamento pedagogico y desarrollo dosente");
                    document.getElementById("B18").setAttribute("name", "Batiz virtual");
                    document.getElementById("B19").setAttribute("name", "Baños mujeres");
                    document.getElementById("B20").setAttribute("name", "Baños hombres");
                    document.getElementById("B21").setAttribute("name", "Programcaion de sistemas digitales");
                    document.getElementById("B22").setAttribute("name", "Laboratorio de aplicacion de sistemas digitales");
                    document.getElementById("B23").setAttribute("name", "Jefatura SD");
                    document.getElementById("B24").setAttribute("name", "Sala de juntas");
                    document.getElementById("B25").setAttribute("name", "Bodega de electronica");
                    document.getElementById("B26").setAttribute("name", "Almacen");
                    document.getElementById("B27").setAttribute("name", "Almacen");
                    document.getElementById("B28").setAttribute("name", "Cubiculo 1");
                    document.getElementById("B29").setAttribute("name", "Cubiculo 2");
                    document.getElementById("B30").setAttribute("name", "Jefatura y sala de profesores");
                    document.getElementById("B31").setAttribute("name", "CHC");
                    document.getElementById("B32").setAttribute("name", "Laboratorio de electronica digital 6°");
                    document.getElementById("B33").setAttribute("name", "Laboratorio de electronica digital 4°");
                    document.getElementById("B34").setAttribute("name", "Laboratorio de electronica");
                    document.getElementById("B35").setAttribute("name", "Bodega");
                    document.getElementById("B36").setAttribute("name", "Bodega");
                    document.getElementById("B37").setAttribute("name", "Autodesc");
                    document.getElementById("B38").setAttribute("name", "Metrologia");
                    document.getElementById("B39").setAttribute("name", "Hidroneumatico");
                    document.getElementById("B40").setAttribute("name", "Electrico");
                }
                if(p == 2){
                    document.getElementById("muestra").className = "pbof";
                    document.getElementById("numPiso").className = "sec2";
                    document.getElementById("numPiso").selectedIndex = "0";
                    document.getElementById("pb").value = "11";
                    document.getElementById("p1").value = "22";
                    document.getElementById("p2").className = "inac";
                    document.getElementById("p3").className = "inac";
                    document.getElementById("B1").setAttribute("name", "Zona de libros");
                    document.getElementById("B2").setAttribute("name", "Zona de dibujo");
                    document.getElementById("B3").setAttribute("name", "Zona de computadoras");
                    document.getElementById("B4").setAttribute("name", "Zona de registro");
                    document.getElementById("B5").setAttribute("name", "Area de lectura");
                    document.getElementById("B6").setAttribute("name", "Cubiculo");
                    document.getElementById("B7").setAttribute("name", "Jefatura");
                    document.getElementById("B8").setAttribute("name", "Sanitario de mujeres");
                    document.getElementById("B9").setAttribute("name", "Sanitario de hombres");
                    document.getElementById("B10").setAttribute("name", "Zona de trofeos");
                    document.getElementById("B11").setAttribute("name", "Servicio medico");
                    document.getElementById("B12").setAttribute("name", "Auditorio");
                    document.getElementById("B13").setAttribute("name", "Oficina del fundador");
                }
                if(p == 3){
                    document.getElementById("muestra").className = "esc";
                    document.getElementById("numPiso").className = "inac";
                }
            }
function redirigirIND(id){
    switch(id){
        case "log":
            window.location="Log.html";
            break;
        case "reg":
            window.location="Reg.html"; 
            break;
    }
}
function redirigirLOG(id){
    switch(id){
        case "alumno":
            window.location="Log-alumno.html";
            break;
        case "profesor":
            window.location="Log-profesor.html"; 
            break;
        case "invitado":
            window.location="Log-invitado.html";
            break;
    }
}
function redirigirREG(id){
    switch(id){
        case "alumno":
            window.location="Reg-alumno.html";
            break;
        case "invitado":
            window.location="Reg-invitado.html";
            break;
    }
}
function redirigirCER(id){
    switch(id){
        case "BC":
            window.location="index.html";
            break;
    }
}
function redirigirPRI(id){
    switch(id){
        case "ConF":
            window.location="Con-espacios.jsp";
            break;
        case "ConR":
            window.location="Con-rutas.html";
            break;
    }
}
function deshabilitaRetroceso(){
    window.location.hash="no-back-button";
    window.location.hash="Again-No-back-button"
    window.onhashchange=function(){window.location.hash="";}
}
function validarnl(e){
    var teclado = (document.all)? e.keyCode : e.which;
    var patron = /[A-Z \ a-z \ 0-9 ]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}
function validarn(e){
    var teclado = (document.all)? e.keyCode : e.which;
    var patron = /[0-9]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}
function validarl(e){
    var teclado = (document.all)? e.keyCode : e.which;
    var patron = /[A-Z \ a-z]/;
    var codigo = String.fromCharCode(teclado);
    return patron.test(codigo);
}
function BotonDes(){
    document.getElementById("myDropdown").classList.toggle("show");
}
window.onclick = function(event){
	if(!event.target.matches('.drop-button')) {
		var dropdowns = document.getElementsByClassName("dropdown-content");
		var i;
		for (i = 0;  i < dropdowns.length; i++) {
		var openDropdown = dropdowns[i];        
		if (openDropdown.classList.contains('show')){
			openDropdown.classList.remove('show');
		}
	  }
	}
};

        </script>
    </body>
</html>
