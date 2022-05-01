<%@page import="Beans.Medicos"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Médicos</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>Id</th>            
            <th>Especialidad</th>
            <th>Tipo Persona</th>
            <th>Colegiatura</th>
            <th>Fecha de Contrato</th>
            <th>Fecha de Registro</th>
            <th>Estado</th>
        </tr>                        
        <%
            ArrayList<Medicos> lista = (ArrayList<Medicos>) request.getAttribute("m_lista");
            for (int i = 0; i < lista.size(); i++) {
                Medicos m = lista.get(i);
        %>
        <tr>
            <td><%=m.getId()%></td>            
            <td><%=m.getEspecialidad()%></td>
            <td><%=m.getTipo_persona()%></td>
            <td><%=m.getCmp()%></td>
            <td><%=m.getFecha_inicio()%></td>  
            <td><%=m.getFecha_reg()%></td>            
            <td><%=m.getEstado()%></td>            
            <td><a href="ServletMedicos?upd=<%=m.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletMedicos?del=<%=m.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
    </table>
</div>               
</body>

</html>