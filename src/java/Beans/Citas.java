package Beans;

public class Citas {
    private int id,estado,idhorario,idpersona,estadocita;
    private String fecha_cita,fecha_ini,fecha_fin,fecha_reg;

    public Citas(int id, int estado, int idhorario, int idpersona, int estadocita, String fecha_cita, String fecha_ini, String fecha_fin, String fecha_reg) {
        this.id = id;
        this.estado = estado;
        this.idhorario = idhorario;
        this.idpersona = idpersona;
        this.estadocita = estadocita;
        this.fecha_cita = fecha_cita;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
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

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getEstadocita() {
        return estadocita;
    }

    public void setEstadocita(int estadocita) {
        this.estadocita = estadocita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
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

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
    
    
}
