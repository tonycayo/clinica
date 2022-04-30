package Beans;

public class Usuarios {
    private int id,estado;
    private String usuario,u_pass,tipo_usuario,fecha_reg;
 
    public Usuarios(int id, String usuario, String u_pass, String tipo_usuario, String fecha_reg, int estado) {
        this.id = id;
        this.estado = estado;
        this.usuario = usuario;
        this.u_pass = u_pass;
        this.tipo_usuario = tipo_usuario;
        this.fecha_reg = fecha_reg;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getFecha_reg() {        
        return fecha_reg;        
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
}
