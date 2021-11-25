package bo.edu.ucb.Sakila.Videoclub.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.Sakila.Videoclub.dto.Payment;
import javax.sql.DataSource;
import java.sql.*;
@Component
public class PaymentDao {


    private DataSource dataSource;
    @Autowired
    public PaymentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public String createPayment(Payment payment){
        String realizado="";
        String query ="INSERT INTO payment VALUES (" +
                "(select max(p.payment_id) from payment p) + 1 ," +
                "( ? )," +
                "( ? ),"+
                "( ? ),"+
                "( ? ),"+
                "now()," +
                "now());";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
        ){
            pstmt.setInt(1,payment.getCustomerId());
            pstmt.setInt(2,payment.getStaffId());
            pstmt.setInt(3,payment.getRentalId());
            pstmt.setString(4,payment.getAmount()+"");
            pstmt.executeUpdate();
            realizado="se Logro";
        }catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
            realizado = "No se logro :(";
        }

        return realizado;
    }

}
