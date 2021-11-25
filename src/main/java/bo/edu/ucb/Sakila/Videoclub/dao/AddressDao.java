package bo.edu.ucb.Sakila.Videoclub.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import bo.edu.ucb.Sakila.Videoclub.dto.Address;
@Component
public class AddressDao {
    private DataSource dataSource;
    @Autowired
    public AddressDao(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public String createAddress(Address address){
        String realizado="";
        String query="INSERT INTO `address` VALUES (" +
                "(select max(a.address_id) from address a)+1," +
                "( ? )," +
                "( ? )," +
                "( ? )," +
                "( ? )," +
                "( ? )," +
                "( ? )," +
                "/*!50705 0x00000000010100000000000000000000000000000000000000,*/now());";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ){
            pstmt.setString(1,address.getAddress());
            pstmt.setString(2,address.getAddress());
            pstmt.setString(3,address.getAddress());
            pstmt.setInt(4,address.getCity());
            pstmt.setString(5,address.getPostalCode());
            pstmt.setString(6,address.getPhone());
            pstmt.executeUpdate();
            realizado="Se logro :)";

        }catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
            realizado = "No se logro :(";
        }
        return realizado;
    }
}
