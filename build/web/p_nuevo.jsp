<%@page import="Beans.Pacientes"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" /> 

<h3 align="center">Nuevo Paciente</h3>
<div class="container">
    <form action="ServletPacientes" method="post">
        <table class="table">                        
            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Paciente activo</label>
            </div>
        </tr><tr>
        <td>Tipo documento: </td>
        <td><input type="text" name="txtTipoDoc" class="form-control"></td>
    </tr><tr>
        <td>Documento: </td>
        <td><input type="password" name="txtDoc" class="form-control"></td>
    </tr><tr>
        <td>Apellido Paterno: </td>
        <td><input type="text" name="txtApePat" class="form-control"></td>
    </tr><tr>
        <td>Apellido Materno: </td>
        <td><input type="text" name="txtApeMat" class="form-control"></td>
    </tr><tr>
        <td>Nombres: </td>
        <td><input type="password" name="txtNombres" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Nacimiento: </td>
        <td><input type="text" name="txtFechaNac" class="form-control"></td>
    </tr><tr>        
        <td>Sexo: </td>
        <td><input type="text" name="txtSexo" class="form-control"></td>
    </tr><tr>
        <td>Correo electrónico: </td>
        <td><input type="text" name="txtEmail" class="form-control"></td>
    </tr><tr>
        <td>¿Es paciente?: </td>
        <td><div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsPaciente" id="flexRadioDefault1" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Sí
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsPaciente" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    No
                </label>
            </div></td>
    </tr><tr>
        <td>¿Es persona?: </td>
        <td><div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsPersona" id="flexRadioDefault1" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Sí
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsPersona" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    No
                </label>
            </div></td>
    </tr><tr>
        <td>¿Es médico?: </td>
        <td><div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsMedico" id="flexRadioDefault1" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    Sí
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioEsMedico" id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    No
                </label>
            </div></td>
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
