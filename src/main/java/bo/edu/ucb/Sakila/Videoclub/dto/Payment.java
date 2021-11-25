package bo.edu.ucb.Sakila.Videoclub.dto;
import java.util.Date;
public class Payment {
    private Integer paymentId;
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private double amount;
    //private Date paymentDate;
    //private Date lastUpDate;
    public Payment(){
        
    }
    /*public Date getLastUpDate() {
        return lastUpDate;
    }*/
    public Integer getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getStaffId() {
        return staffId;
    }
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public Integer getRentalId() {
        return rentalId;
    }
    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    /*public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public void setLastUpDate(Date lastUpDate) {
        this.lastUpDate = lastUpDate;
    }*/
}
