<%@page import="Beans.Pacientes"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Paciente</h3>
<div class="container">
    <form action="ServletPacientes" method="post">
        <table class="table">    

            <%
                ArrayList<Pacientes> lista = (ArrayList<Pacientes>) request.getAttribute("p_lista");
                for (int i = 0; i < lista.size(); i++) {
                    Pacientes p = lista.get(i);
            %>

            <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Paciente activo</label>
            </div>
        </tr><tr>
        <td>Tipo documento: </td>
        <td><input type="text" name="txtTipoDoc" value="<%=p.getTipo_doc()%>" class="form-control"></td>
    </tr><tr>
        <td>Documento: </td>
        <td><input type="text" name="txtDoc" value="<%=p.getDoc()%>" class="form-control"></td>
    </tr><tr>
        <td>Apellido Paterno: </td>
        <td><input type="text" name="txtApePat" value="<%=p.getApepat()%>" class="form-control"></td>
    </tr><tr>
        <td>Apellido Materno: </td>
        <td><input type="text" name="txtApeMat" value="<%=p.getApemat()%>" class="form-control"></td>
    </tr><tr>
        <td>Nombres: </td>
        <td><input type="text" name="txtNombres" value="<%=p.getNombres()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Nacimiento: </td>
        <td><input type="text" name="txtFechaNac" value="<%=p.getFecha_nac()%>" class="form-control"></td>
    </tr><tr>        
        <td>Sexo: </td>
        <td><input type="text" name="txtSexo" value="<%=p.getSexo()%>" class="form-control"></td>
    </tr><tr>
        <td>Correo electrónico: </td>
        <td><input type="text" name="txtEmail" value="<%=p.getEmail()%>" class="form-control"></td>
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

    <input type="hidden" name="updId" value="<%=p.getId()%>">
    <%
        }
    %>       


</table>
<input type="hidden" name="op" value="update">

</form>
</div>               
</body>

</html>
