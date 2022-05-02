package Utils;

import java.sql.*;

public class ConexionDB {

    public static Connection getConexion() {
        Connection con = null;
        String cadena = "jdbc:mysql://localhost/clinica?user=root&password=&useUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena);
            System.out.println("Conexión satisfactoria");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        getConexion();
    }

}
