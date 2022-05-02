<%@page import="Beans.Especialidades"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" /> 

<h3 align="center">Nueva Especialidad</h3>
<div class="container">
    <form action="ServletEspecialidades" method="post">
        <table class="table">                        
            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Registro activo</label>
            </div>
        </tr><tr>        
        <td>Código: </td>
        <td><input type="text" name="txtCodigo" class="form-control"></td>
    </tr><tr>
        <td>Descripción: </td>
        <td><input type="text" name="txtDescripcion" class="form-control"></td>
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
