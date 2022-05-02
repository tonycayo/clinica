<%@page import="Beans.Horarios"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" /> 

<h3 align="center">Nuevo Horario</h3>
<div class="container">
    <form action="ServletHorarios" method="post">
        <table class="table">                        
            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Registro activo</label>
            </div>
        </tr><tr>
        <td>Médico: </td>
        <td><input type="text" name="txtIdpersona" class="form-control"></td>
    </tr><tr>
        <td>Especialidad: </td>
        <td><input type="text" name="txtIdespecialidad" class="form-control"></td>
    </tr><tr>
        <td>Fecha Inicio: </td>
        <td><input type="text" name="txtFecha_ini" class="form-control"></td>
    </tr><tr>
        <td>Fecha Fin: </td>
        <td><input type="text" name="txtFecha_fin" class="form-control"></td>
    </tr><tr>
        <td>Tipo de Horario: </td>
        <td><input type="text" name="txtTipo_horario" class="form-control"></td>
    </tr><tr>
        <td>Comentarios: </td>
        <td><input type="text" name="txtComentarios" class="form-control"></td>       
    </tr>
    <td></td>
    <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr>
</table>
<input type="hidden" name="op" value="nuevo">
</form>
</div>               
</body>

</html>

