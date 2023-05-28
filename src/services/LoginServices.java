package services;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import database.Conexion;
import entitys.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Types;
import views.Login;

public class LoginServices {

    Connection con = Conexion.getConex();
    

    public User ValidateLogin(String email, String password) throws SQLException {
        try ( CallableStatement conect = con.prepareCall("{call validate_login(?,?,?,?,?,?,?,?,?)}")) {
            conect.setString(1, email);
            conect.setString(2, password);
            conect.registerOutParameter(3, Types.VARCHAR);
            conect.registerOutParameter(4, Types.VARCHAR);
            conect.registerOutParameter(5, Types.VARCHAR);
            conect.registerOutParameter(6, Types.VARCHAR);
            conect.registerOutParameter(7, Types.VARCHAR);
            conect.registerOutParameter(8, Types.VARCHAR);
            conect.registerOutParameter(9, Types.VARCHAR);
            conect.execute();
            int user_id = conect.getInt (3);
            String email_out = conect.getString(4);
            String name = conect.getString(5);
            String father_last_name = conect.getString(6);
            String mother_last_name = conect.getString(7);
            int rol_id = conect.getInt(8);
            String rol_name = conect.getString(9);

            User user = new User (user_id, email_out, name,father_last_name,mother_last_name,rol_id,rol_name);


            conect.close();
            if (user_id == 0) {
               conect.close();
               con.close();
                return null;
            } else {
                conect.close();
               con.close();
//               Login login = new Login(user);
                return user;
            }
        }

    }

}
