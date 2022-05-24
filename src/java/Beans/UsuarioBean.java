package Beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean {

    private int idpersona,estado;
    private String usuario,password,tipousuario,fecha;
            
    public UsuarioBean() {
    }

    public UsuarioBean(int idpersona, String usuario, String password, String tipousuario, String fecha, int estado) {
        this.idpersona = idpersona;        
        this.usuario = usuario;
        this.password = password;
        this.tipousuario = tipousuario;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    
}
