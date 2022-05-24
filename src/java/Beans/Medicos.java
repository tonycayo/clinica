package Beans;

public class Medicos {
    private int id,estado,especialidad;
    private String tipo_persona,cmp,fecha_inicio,fecha_reg;

    public Medicos(int id, int especialidad, String tipo_persona, String cmp, String fecha_inicio, String fecha_reg, int estado) {
        this.id = id;
        this.estado = estado;
        this.especialidad = especialidad;
        this.tipo_persona = tipo_persona;
        this.cmp = cmp;
        this.fecha_inicio = fecha_inicio;
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

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getCmp() {
        return cmp;
    }

    public void setCmp(String cmp) {
        this.cmp = cmp;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
    
    
}
