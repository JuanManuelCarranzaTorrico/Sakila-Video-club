package bo.edu.ucb.Sakila.Videoclub.dao;
import bo.edu.ucb.Sakila.Videoclub.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerDao {
    private DataSource dataSource;
    @Autowired
    public CustomerDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public String createCustomer(Customer customer){
        String realizado="";
        String query ="INSERT INTO customer VALUES ("+
                "(select max(r.customer_id) from customer r ) +1,"+
                "( ? ),"+
                "( ? ),"+
                "( ? ),"+
                "( ? ),"+
                "( ? ),"+
                "( ? ),"+
                "now(),"+
                "now());";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ) {
           // pstmt.setInt(1,customer.getCustomerId());
            pstmt.setInt(1,customer.getStoreId());
            pstmt.setString(2,customer.getFirstName());
            pstmt.setString(3,customer.getLastName());
            pstmt.setString(4,customer.getEmail());
            pstmt.setInt(5,customer.getAddressId());
            pstmt.setInt(6,customer.getActive());
            pstmt.executeUpdate();
            realizado="se Logro";

        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
            realizado = "No se logro :(";
        }

        return realizado;
    }
}
