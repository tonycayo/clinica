<%@page import="Beans.Medicos"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" /> 

<h3 align="center">Nuevo Médico</h3>
<div class="container">
    <form action="ServletMedicos" method="post">
        <table class="table">                        
            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Médico activo</label>
            </div>
        </tr><tr>
        <td>ID especialidad: </td>
        <td><input type="text" name="txtEspecialidad" class="form-control"></td>
    </tr><tr>
        <td>Tipo Persona: </td>
        <td><input type="text" name="txtTipoPersona" class="form-control"></td>
    </tr><tr>
        <td>Código CMP: </td>
        <td><input type="text" name="txtCodCMP" class="form-control"></td>
    </tr><tr>
        <td>Fecha de inicio de labores: </td>
        <td><input type="text" name="txtFechaIng" class="form-control"></td>
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr>
</table>
<input type="hidden" name="op" value="nuevo">
</form>
</div>               
</body>

</html>
