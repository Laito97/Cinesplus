package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import database.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryServices {

    Connection con = Conexion.getConex();

    public ArrayList ListCategory() throws SQLException {
        ArrayList<String> categoryData = new ArrayList<String>(); 
        Statement conect = con.createStatement();
        ResultSet result = conect.executeQuery("Select * From category");
        while (result.next()) {
        String id = result.getString("category_id");
        String name = result.getString("name");
        String item = id + "-" + name;

            categoryData.add(item);
        };
        conect.close();
        result.close();
        con.close();
        return categoryData;
    }

}
