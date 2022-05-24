package Beans;

public class Horarios {
    private int id,idpersona,idespecialidad,estado;
    private String fecha_ini,fecha_fin,tipo_horario,comentarios,fecha_reg;

    public Horarios(int id, int idpersona, int idespecialidad, String fecha_ini, String fecha_fin, String tipo_horario, String comentarios, String fecha_reg, int estado) {
        this.id = id;        
        this.idpersona = idpersona;
        this.idespecialidad = idespecialidad;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.tipo_horario = tipo_horario;
        this.comentarios = comentarios;
        this.fecha_reg = fecha_reg;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(int idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo_horario() {
        return tipo_horario;
    }

    public void setTipo_horario(String tipo_horario) {
        this.tipo_horario = tipo_horario;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
    
}
