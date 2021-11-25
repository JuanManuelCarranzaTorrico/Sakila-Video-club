package bo.edu.ucb.Sakila.Videoclub.bl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.Sakila.Videoclub.dto.Payment;
import bo.edu.ucb.Sakila.Videoclub.dao.PaymentDao;
@Component
public class PaymentBl {
    private final PaymentDao paymentDao;
    @Autowired
    public PaymentBl(PaymentDao paymentDao){
        this.paymentDao=paymentDao;
    }
    public String createPayment(Payment payment){
        return paymentDao.createPayment(payment);
    }
}
