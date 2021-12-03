package bo.edu.ucb.Sakila.Videoclub.dao;
import bo.edu.ucb.Sakila.Videoclub.dto.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class RentalDao {
    private DataSource dataSource;
    @Autowired
    public RentalDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public String createRental(Rental rental){
        String realizado="";
        String query="INSERT INTO rental VALUES (" +
                "(select max(r.rental_id) from rental r ) +1," +
                "now()," +
                "(select i.inventory_id from inventory i where i.film_id=( ? ) limit 1)," +
                "( ? )," +
                "now()," +
                "( ? )," +
                "now());";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ){
            pstmt.setInt(1,rental.getInventoryId());
            pstmt.setInt(2,rental.getCustomerId());
            pstmt.setInt(3,rental.getStaffId());
            pstmt.executeUpdate();
            realizado="Se logro :)";

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
            realizado = "No se logro :(";
        }


        return realizado;
    }
}
