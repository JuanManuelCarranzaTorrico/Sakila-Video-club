package bo.edu.ucb.Sakila.Videoclub.dao;

import bo.edu.ucb.Sakila.Videoclub.dto.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MostFilmDao {

    private DataSource dataSource;
    @Autowired
    public MostFilmDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findTheMost(int country) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT f.film_id, " +
                "   f.title, " +
                "   f.description, " +
                "   f.release_year, " +
                "   l.name as language , " +
                "   ol.name as original_language, " +
                "   f.length, " +
                "   f.rating, "  +
                "   f.special_features, " +
                "   f.last_update " +
                "   from film f "+
                "   Left join inventory i on (i.film_id=f.film_id)  "+
                "   Left join rental r on (r.inventory_id = i.inventory_id) "+
                "   Left join store s on (s.store_id=i.store_id)    "+
                "   Left join address a on (a.address_id=s.address_id)  "+
                "   Left join city ct on (ct.city_id=a.city_id) "+
                "   Left join country cn on (cn.country_id=ct.country_id)   "+
                "   LEFT JOIN language l ON ( f.language_id = l.language_id)    "+
                "   LEFT JOIN language ol ON ( f.original_language_id = ol.language_id) "+
                "   where s.store_id= ( ? )  "+
                "   group by f.film_id  "+
                "order by count(r.rental_id) desc;";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println(query);
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            int contador=0;
            while(rs.next()&contador<10) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setReleaseYear(rs.getShort("release_year"));
                film.setLanguage("language");
                film.setOriginalLanguage("original_language");
                film.setLength(rs.getInt("length"));
                film.setRating(rs.getString("rating"));
                film.setSpecialFeatures(rs.getString("special_features"));
                java.sql.Date lastUpdate = rs.getDate("last_update");
                film.setLastUpdate(new java.util.Date(lastUpdate.getTime()));

                result.add(film);
                contador++;
            }
            //Probamos la respuesta xd
            System.out.println(result);
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }
    // Parte 2


    public List<Film> findPremier(int country) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT f.film_id, " +
                "   f.title, " +
                "   f.description, " +
                "   f.release_year, " +
                "   l.name as language , " +
                "   ol.name as original_language, " +
                "   f.length, " +
                "   f.rating, "  +
                "   f.special_features, " +
                "   f.last_update " +
                "   from film f "+
                "   left join inventory i on (i.film_id=f.film_id)  "+
                "   left join rental r on (r.inventory_id=i.inventory_id)   "+
                "   left join store s on (s.store_id=i.store_id)  "+
                "   left join address a on (a.address_id=s.address_id) "+
                "   left join city cy on (cy.city_id=a.city_id)   " +
                "   left join country cc on(cc.country_id=cy.country_id)" +
                "   left join film_category fc on (fc.film_id=f.film_id)" +
                "   left join category c on(c.category_id=fc.category_id)"+
                "   LEFT JOIN language l ON ( f.language_id = l.language_id)    "+
                "   LEFT JOIN language ol ON ( f.original_language_id = ol.language_id) "+
                "   where s.store_id= ( ? )  "+
                "   ORDER BY film_id DESC  "+
                "LIMIT 10;" ;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
            System.out.println(query);
            pstmt.setInt(1, country);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setReleaseYear(rs.getShort("release_year"));
                film.setLanguage("language");
                film.setOriginalLanguage("original_language");
                film.setLength(rs.getInt("length"));
                film.setRating(rs.getString("rating"));
                film.setSpecialFeatures(rs.getString("special_features"));
                java.sql.Date lastUpdate = rs.getDate("last_update");
                film.setLastUpdate(new java.util.Date(lastUpdate.getTime()));

                result.add(film);
            }
            //Probamos la respuesta xd
            System.out.println(result);
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }



}