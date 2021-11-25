package bo.edu.ucb.Sakila.Videoclub.bl;
import bo.edu.ucb.Sakila.Videoclub.dao.CustomerDao;
import bo.edu.ucb.Sakila.Videoclub.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerBl {
    private final CustomerDao customerDao;
    @Autowired

    public CustomerBl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public String createCustomer (Customer customer){
        return customerDao.createCustomer(customer);
    }
}
