package Beans;

public class Especialidades {
    private int id,estado;
    private String codigo,descripcion,fecha_reg;

    public Especialidades(int id, String codigo, String descripcion, String fecha_reg, int estado) {
        this.id = id;        
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha_reg = fecha_reg;
        this.estado = estado;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
    
    
}
