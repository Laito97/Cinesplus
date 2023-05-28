/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import database.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Laito
 */
public class MovieDetailServices {
    
      Connection con = Conexion.getConex();
      
        public void RegisterMoviesTickets(int movieid, String seating, String schedule) throws SQLException {
        CallableStatement conect = con.prepareCall("{call movies_detail_register(?,?,?)}");
        conect.setInt(1, movieid);
        conect.setString(2,seating);
        conect.setString(3,schedule);
        conect.execute();     
        conect.close();
        }
}
