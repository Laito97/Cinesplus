package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConex() {
        try {
            String URL = "jdbc:mysql://localhost:3306/cineplus";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conect = DriverManager.getConnection(URL, user, password);
            return conect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
