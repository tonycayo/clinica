<%@page import="Beans.Horarios"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Horario</h3>
<div class="container">
    <form action="ServletHorarios" method="post">
        <table class="table">    

            <%
                ArrayList<Horarios> lista = (ArrayList<Horarios>) request.getAttribute("h_lista");
                for (int i = 0; i < lista.size(); i++) {
                    Horarios h = lista.get(i);
            %>

            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Registro activo</label>
            </div>
        </tr><tr>
        <td>Médico: </td>
        <td><input type="text" name="txtIdpersona" value="<%=h.getIdpersona()%>" class="form-control"></td>
    </tr><tr>
        <td>Especialidad: </td>
        <td><input type="text" name="txtIdespecialidad" value="<%=h.getIdespecialidad()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha Inicio: </td>
        <td><input type="text" name="txtFecha_ini" value="<%=h.getFecha_ini()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha Fin: </td>
        <td><input type="text" name="txtFecha_fin" value="<%=h.getFecha_fin()%>" class="form-control"></td>
    </tr><tr>
        <td>Tipo de Horario: </td>
        <td><input type="text" name="txtTipo_horario" value="<%=h.getTipo_horario()%>" class="form-control"></td>
    </tr><tr>
        <td>Comentarios: </td>
        <td><input type="text" name="txtComentarios" value="<%=h.getComentarios()%>" class="form-control"></td>       
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr>
    <input type="hidden" name="updId" value="<%=h.getId()%>">
    <%
        }
    %>                      

</table>
<input type="hidden" name="op" value="update">

</form>
</div>               
</body>

</html>
