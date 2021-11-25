package bo.edu.ucb.Sakila.Videoclub.bl;
import bo.edu.ucb.Sakila.Videoclub.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.Sakila.Videoclub.dao.AddressDao;
@Component
public class AddressBl {
    private final AddressDao addressDao;
    @Autowired
    public AddressBl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }
    public String createAddress(Address address){
        return addressDao.createAddress(address);
    }
}
