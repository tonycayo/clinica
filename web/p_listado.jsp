<%@page import="Beans.Pacientes"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Listado de Pacientes</h3>
<div class="container">
    <table class="table">                        
        <tr>
            <th>Id</th>
            <th>Ap.Pat.</th>
            <th>Ap.Mat.</th>
            <th>Nombres</th>
            <th>FechaNac</th>
            <th>Sexo</th>                   
            <th>FechaReg</th>
            <th>Estado</th>            
        </tr>                        
        <%
            ArrayList<Pacientes> lista = (ArrayList<Pacientes>) request.getAttribute("p_lista");
            for (int i = 0; i < lista.size(); i++) {
                Pacientes p = lista.get(i);
        %>
        <tr>
            <td><%=p.getId()%></td>
            <td><%=p.getApepat()%></td>
            <td><%=p.getApemat()%></td>
            <td><%=p.getNombres()%></td>                      
            <td><%=p.getFecha_nac()%></td>
            <td><%=p.getSexo()%></td>            
            <td><%=p.getFecha_reg()%></td>
            <td><%=p.getEstado()%></td> 
            <td><a href="ServletPacientes?upd=<%=p.getId()%>"><button class="btn btn-primary">Editar</button></a></td> <!--btn btn-primary es un boton de bootstrap de color azul-->
            <td><a href="ServletPacientes?del=<%=p.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td> <!--btn btn-danger es un boton de bootstrap para mostrar peligro-->
        </tr>
        <%
            }
        %>
    </table>
</div>               
</body>

</html>
