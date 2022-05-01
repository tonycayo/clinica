<%@page import="Beans.Citas"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Cita</h3>
<div class="container">
    <form action="ServletCitas" method="post">
    <table class="table">    
                       
        <%
            ArrayList<Citas> lista = (ArrayList<Citas>) request.getAttribute("c_lista");
            for (int i = 0; i < lista.size(); i++) {
                Citas c = lista.get(i);
        %>
               
        <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Cita activa</label>
            </div>
        </tr><tr>
        <td>ID Cita: </td>
        <td><input type="text" name="txtIDcita" value="<%=c.getId()%>" class="form-control"></td>
    </tr><tr>
        <td>ID Horario: </td>
        <td><input type="text" name="txtIDhorario" value="<%=c.getIdhorario()%>" class="form-control"></td>
    </tr><tr>
        <td>ID Persona: </td>
        <td><input type="text" name="txtIDpersona" value="<%=c.getIdpersona()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Inicio: </td>
        <td><input type="text" name="txtFechaIni" value="<%=c.getFecha_ini()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha de Final: </td>
        <td><input type="text" name="txtFechaFin" value="<%=c.getFecha_fin()%>" class="form-control"></td>
    </tr><tr>
        <td>Fecha de registro: </td>
        <td><input type="text" name="txtFechaReg" value="<%=c.getFecha_reg()%>" class="form-control"></td>
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr>
        <input type="hidden" name="updId" value="<%=c.getId()%>">
        <%
            }
        %>                      
    
    </table>
    <input type="hidden" name="op" value="update">
    
</form>
</div>               
</body>

</html>

