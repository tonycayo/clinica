package Beans;

public class Pacientes {
    private int id,estado,espaciente,espersona,esmedico;
    private String tipo_doc,doc,apepat,apemat,nombres,nombrecompleto,sexo,email,fecha_nac,fecha_reg;

    public Pacientes(int id, int estado, int espaciente, int espersona, int esmedico, String tipo_doc, String doc, String apepat, String apemat, String nombres, String nombrecompleto, String sexo, String email, String fecha_nac, String fecha_reg) {
        this.id = id;
        this.estado = estado;
        this.espaciente = espaciente;
        this.espersona = espersona;
        this.esmedico = esmedico;
        this.tipo_doc = tipo_doc;
        this.doc = doc;
        this.apepat = apepat;
        this.apemat = apemat;
        this.nombres = nombres;
        this.nombrecompleto = nombrecompleto;
        this.sexo = sexo;
        this.email = email;
        this.fecha_nac = fecha_nac;
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

    public int getEspaciente() {
        return espaciente;
    }

    public void setEspaciente(int espaciente) {
        this.espaciente = espaciente;
    }

    public int getEspersona() {
        return espersona;
    }

    public void setEspersona(int espersona) {
        this.espersona = espersona;
    }

    public int getEsmedico() {
        return esmedico;
    }

    public void setEsmedico(int esmedico) {
        this.esmedico = esmedico;
    }

    public String getTipo_doc() {
        return tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        this.tipo_doc = tipo_doc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }
    
    
    
    
}
