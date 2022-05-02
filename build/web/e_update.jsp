<%@page import="Beans.Especialidades"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Especialidad</h3>
<div class="container">
    <form action="ServletEspecialidades" method="post">
    <table class="table">    
                       
        <%
            ArrayList<Especialidades> lista = (ArrayList<Especialidades>) request.getAttribute("e_lista");
            for (int i = 0; i < lista.size(); i++) {
                Especialidades e = lista.get(i);
        %>
               
        <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Registro activo</label>
            </div>
        </tr><tr>        
        <td>Código: </td>
        <td><input type="text" name="txtCodigo" value="<%=e.getCodigo()%>" class="form-control"></td>
    </tr><tr>
        <td>Descripción: </td>
        <td><input type="text" name="txtDescripcion" value="<%=e.getDescripcion()%>" class="form-control"></td>
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr>
        <input type="hidden" name="updId" value="<%=e.getId()%>">
        <%
            }
        %>                      
    
    </table>
    <input type="hidden" name="op" value="update">
    
</form>
</div>               
</body>

</html>
