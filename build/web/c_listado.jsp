<%@page import="Beans.Citas"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Citas</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>ID</th>
            <th>ID Horario</th>
            <th>ID Persona</th>
            <th>Fecha inicio</th>
            <th>Fecha final</th>
            <th>Fecha de Registro</th>
            <th>Estado</th>
        </tr>                        
        <%
            ArrayList<Citas> lista = (ArrayList<Citas>) request.getAttribute("c_lista");
            for (int i = 0; i < lista.size(); i++) {
                Citas c = lista.get(i);
        %>
        <tr>
            <td><%=c.getId()%></td>
            <td><%=c.getIdhorario()%></td>
            <td><%=c.getIdpersona()%></td>            
            <td><%=c.getFecha_ini()%></td>
            <td><%=c.getFecha_fin()%></td>
            <td><%=c.getFecha_reg()%></td>            
            <td><%=c.getEstado()%></td> 
            <td><a href="ServletCitas?upd=<%=c.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletCitas?del=<%=c.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
    </table>
</div>               
</body>

</html>
