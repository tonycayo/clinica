package Beans;

public class Logs {

    private int id;
    private String login, remote_addr, remote_host, x_forwarded_for, accion, url, fecha_reg;

    public Logs(int id, String login, String remote_addr, String remote_host, String x_forwarded_for, String accion, String url, String fecha_reg) {
        this.id = id;
        this.login = login;
        this.remote_addr = remote_addr;
        this.remote_host = remote_host;
        this.x_forwarded_for = x_forwarded_for;
        this.accion = accion;
        this.url = url;
        this.fecha_reg = fecha_reg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRemote_addr() {
        return remote_addr;
    }

    public void setRemote_addr(String remote_addr) {
        this.remote_addr = remote_addr;
    }

    public String getRemote_host() {
        return remote_host;
    }

    public void setRemote_host(String remote_host) {
        this.remote_host = remote_host;
    }

    public String getX_forwarded_for() {
        return x_forwarded_for;
    }

    public void setX_forwarded_for(String x_forwarded_for) {
        this.x_forwarded_for = x_forwarded_for;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

}
