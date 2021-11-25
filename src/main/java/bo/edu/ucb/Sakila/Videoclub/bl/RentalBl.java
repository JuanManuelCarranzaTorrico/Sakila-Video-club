package bo.edu.ucb.Sakila.Videoclub.bl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bo.edu.ucb.Sakila.Videoclub.dto.Rental;
import bo.edu.ucb.Sakila.Videoclub.dao.RentalDao;
@Component
public class RentalBl {
    private  final RentalDao rentalDao;
    @Autowired

    public RentalBl(RentalDao rentalDao) {
        this.rentalDao = rentalDao;
    }
    public String createRental(Rental rental){
        return rentalDao.createRental(rental);
    }
}
