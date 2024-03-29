<%@page import="Beans.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Usuarios</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>Id</th>            
            <th>Usuario</th>
            <th>Tipo de Usuario</th>
            <th>Fecha de Registro</th>
            <th>Estado</th>
        </tr>                        
        <%
            ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("u_lista");
            for (int i = 0; i < lista.size(); i++) {
                Usuarios u = lista.get(i);
        %>
        <tr>
            <td><%=u.getId()%></td>            
            <td><%=u.getUsuario()%></td>            
            <td><%=u.getTipo_usuario()%></td>
            <td><%=u.getFecha_reg()%></td>            
            <td><%=u.getEstado()%></td>
            <td><a href="ServletUsuarios?upd=<%=u.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletUsuarios?del=<%=u.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
        <tr><td></td>
            <td><a href="u_nuevo.jsp"><button class="btn btn-success">Agregar registro</button></a></td> <!--btn btn-success es un boton de bootstrap de color verde-->
        </tr>    
    </table>
</div>               
</body>

</html>
