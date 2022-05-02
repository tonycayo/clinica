<%@page import="Beans.Especialidades"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Especialidades</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>Id</th>            
            <th>Código</th>
            <th>Descripción</th>            
            <th>Fecha de Registro</th>
            <th>Estado</th>
        </tr>                        
        <%
            ArrayList<Especialidades> lista = (ArrayList<Especialidades>) request.getAttribute("e_lista");
            for (int i = 0; i < lista.size(); i++) {
                Especialidades e = lista.get(i);
        %>
        <tr>
            <td><%=e.getId()%></td>            
            <td><%=e.getCodigo()%></td>
            <td><%=e.getDescripcion()%></td>            
            <td><%=e.getFecha_reg()%></td>            
            <td><%=e.getEstado()%></td>
            <td><a href="ServletEspecialidades?upd=<%=e.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletEspecialidades?del=<%=e.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
        <tr><td></td>
            <td><a href="e_nuevo.jsp"><button class="btn btn-success">Agregar registro</button></a></td> <!--btn btn-success es un boton de bootstrap de color verde-->
        </tr>    
    </table>
</div>               
</body>

</html>
