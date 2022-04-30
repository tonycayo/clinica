package Utils;

public class Tools {

    public static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date hoy = new java.util.Date();
        return new java.sql.Timestamp(hoy.getTime());

    }
}
