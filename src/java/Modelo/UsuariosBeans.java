package Modelo;

import Beans.UsuarioBean;
import Utils.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.*;

@Named(value = "usuariosBeans")
@RequestScoped
public class UsuariosBeans {

    @Inject
    private UsuarioBean usu;

    public UsuariosBeans() {
    }

    public ArrayList<UsuarioBean> getListaUsu() {
        ArrayList<UsuarioBean> data = new ArrayList<>();
        ConexionDB cn = new ConexionDB();
        try {
            Statement sql = cn.getConexion().createStatement();
            ResultSet rs = sql.executeQuery("select * from usuario");
            while (rs.next()) {
                UsuarioBean u = new UsuarioBean(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6));
                data.add(u);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return data;
    }
}
