<%@page import="Beans.Medicos"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Médico</h3>
<div class="container">
    <form action="ServletMedicos" method="post">
        <table class="table">    

            <%
                ArrayList<Medicos> lista = (ArrayList<Medicos>) request.getAttribute("m_lista");
                for (int i = 0; i < lista.size(); i++) {
                    Medicos m = lista.get(i);
            %>

            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Médico activo</label>
            </div>
        </tr><tr>
        <td>ID especialidad: </td>
        <td><input type="text" name="txtEspecialidad" value="<%=m.getEspecialidad()%>" class="form-control"></td>
    </tr><tr>
        <td>Tipo Persona: </td>
        <td><input type="txt" name="txtTipoPersona" value="<%=m.getTipo_persona()%>" class="form-control"></td>
    </tr><tr>
        <td>Código CMP: </td>
        <td><input type="text" name="txtCodCMP" value="<%=m.getCmp()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha de inicio de labores: </td>
        <td><input type="text" name="txtFechaIng" value="<%=m.getFecha_inicio()%>" class="form-control"></td>
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr><!-- comment -->
    <input type="hidden" name="updId" value="<%=m.getId()%>">
    <%
        }
    %>       


</table>
<input type="hidden" name="op" value="update">

</form>
</div>               
</body>

</html>
