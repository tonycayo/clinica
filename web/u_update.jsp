<%@page import="Beans.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="header.jsp" />  

<h3 align="center">Actualizar Usuario</h3>
<div class="container">
    <form action="ServletUsuarios" method="post">
    <table class="table">    
                       
        <%
            ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("u_lista");
            for (int i = 0; i < lista.size(); i++) {
                Usuarios u = lista.get(i);
        %>
               
        <tr>
            <div class="form-check form-switch">
                <input class="form-check-input" type="checkbox" role="switch" name="chkActivo" id="flexSwitchCheckChecked" checked>
                <label class="form-check-label" for="flexSwitchCheckChecked">Usuario activo</label>
            </div>
        </tr><tr>
        <td>Usuario: </td>
        <td><input type="text" name="txtUsuario" value="<%=u.getUsuario()%>" class="form-control"></td>
    </tr><tr>
        <td>Password: </td>
        <td><input type="password" name="txtPassword" value="<%=u.getU_pass()%>" class="form-control"></td>
    </tr><tr>
        <td>Tipo de Usuario: </td>
        <td><input type="text" name="txtTipoUsuario" value="<%=u.getTipo_usuario()%>" class="form-control"></td>
    </tr><tr>
        <td></td>
        <td><input type="submit" value="Grabar Datos" class="btn btn-success"></td>
    </tr><!-- comment -->
        <input type="hidden" name="updId" value="<%=u.getId()%>">
        <%
            }
        %>       
               
    
    </table>
    <input type="hidden" name="op" value="update">
    
</form>
</div>               
</body>

</html>
