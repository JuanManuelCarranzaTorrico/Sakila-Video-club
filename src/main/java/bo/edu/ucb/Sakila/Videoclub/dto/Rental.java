package bo.edu.ucb.Sakila.Videoclub.dto;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Rental {
    private Integer rentalId;
    //private Date rentalDate;
    private Integer inventoryId;
    private Integer customerId;
    //private Date returnDate;
    private Integer staffId;
    //private Date lastUpdate;

    public Rental(){
        
    }

    public Integer getRentalId() {
        return rentalId;
    }
    /*public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }*/
    public Integer getStaffId() {
        return staffId;
    }
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    /*public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }*/
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getInventoryId() {
        return inventoryId;
    }
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }
    /*public Date getRentalDate() {
        return rentalDate;
    }
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }*/
    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }
    
   
}
