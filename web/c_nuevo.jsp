<%@page import="Beans.Citas"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" /> 

<h3 align="center">Nueva Cita</h3>
<div class="container">
    <form action="ServletCitas" method="post">
        <table class="table">                        
            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Cita activa</label>
            </div>
        </tr><tr>
        <td>ID Cita: </td>
        <td><input type="text" name="txtIDcita" class="form-control"></td>
    </tr><tr>
        <td>ID Horario: </td>
        <td><input type="text" name="txtIDhorario" class="form-control"></td>
    </tr><tr>
        <td>ID Persona: </td>
        <td><input type="text" name="txtIDpersona" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Inicio: </td>
        <td><input type="text" name="txtFechaIni" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Final: </td>
        <td><input type="text" name="txtFechaFin" class="form-control"></td>
    </tr><tr>
        <td>Fecha de registro: </td>
        <td><input type="text" name="txtFechaReg" class="form-control"></td>
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
