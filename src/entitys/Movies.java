
package entitys;

import java.sql.SQLException;
import services.CategoryServices;
import services.MoviesServices;

public class Movies {

    public static void main(String[] args) throws SQLException {
//       MoviesServices movie = new  MoviesServices();
//       movie.ListMovies();
       
       CategoryServices category = new CategoryServices();
       category.ListCategory();
       
    }
    
}
