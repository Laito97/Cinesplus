package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.CallableStatement;
import database.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;


public class MoviesServices {

    Connection con = Conexion.getConex();

    public ArrayList ListMovies() throws SQLException {
        ArrayList<String[]> movieData = new ArrayList<String[]>();
        Statement conect = con.createStatement();
        ResultSet result = conect.executeQuery("call movies_list");
        while (result.next()) {
            String state = "";
            if (result.getInt("state") == 0) {
                state = "INHABILITADO";
            } else {
                state = "HABILITADO";
            }

            String[] fila = {
                result.getString("movie_id"),
                result.getString("name"),
                result.getString("description"),
                result.getString("category_name"),
                state
            };
            movieData.add(fila);
        };
        conect.close();
        result.close();
        con.close();
        return movieData;

    }
    
     public ArrayList searchMovie() throws SQLException {
        ArrayList<String> movieData = new ArrayList<String>(); 
        Statement conect = con.createStatement();
        ResultSet result = conect.executeQuery("Select * From movies");
        while (result.next()) {
        String id = result.getString("movie_id");
        String name = result.getString("name");
        String item = id + "-" + name;

            movieData.add(item);
        };
        conect.close();
        result.close();
        con.close();
        return movieData;
    }
    
    public void RegisterMovies(String titulo, String descripcion, int categoria) throws SQLException {
        CallableStatement conect = con.prepareCall("{call movies_register(?,?,?)}");
        conect.setString(1, titulo);
        conect.setString(2,descripcion);
        conect.setInt(3,categoria);
        conect.execute();     
        conect.close();
        }
}