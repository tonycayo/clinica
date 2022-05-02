<%@page import="Beans.Horarios"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Horarios</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>Id</th>            
            <th>Médico</th>
            <th>Especialidad</th>
            <th>Fecha Inicio</th>
            <th>Fecha Fin</th>
            <th>Tipo de Horario</th>
            <th>Comentarios</th>
            <th>Fecha de Registro</th>
            <th>Estado</th>
        </tr>                        
        <%
            ArrayList<Horarios> lista = (ArrayList<Horarios>) request.getAttribute("h_lista");
            for (int i = 0; i < lista.size(); i++) {
                Horarios h = lista.get(i);
        %>
        <tr>
            <td><%=h.getId()%></td>            
            <td><%=h.getIdpersona()%></td>
            <td><%=h.getIdespecialidad()%></td>
            <td><%=h.getFecha_ini()%></td>
            <td><%=h.getFecha_fin()%></td>
            <td><%=h.getTipo_horario()%></td>
            <td><%=h.getComentarios()%></td>
            <td><%=h.getFecha_reg()%></td>            
            <td><%=h.getEstado()%></td>
            <td><a href="ServletHorarios?upd=<%=h.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletHorarios?del=<%=h.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
        <tr><td></td>
            <td><a href="h_nuevo.jsp"><button class="btn btn-success">Agregar registro</button></a></td> <!--btn btn-success es un boton de bootstrap de color verde-->
        </tr>    
    </table>
</div>               
</body>

</html>
