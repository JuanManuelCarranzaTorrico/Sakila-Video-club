package bo.edu.ucb.Sakila.Videoclub.dto;

import java.util.Date;

public class Address {
    private  Integer addresId;
    private String address;
    private String address2;
    private String district;
    private int city;
    private String postalCode;
    private String phone;
   // private Date lastUpDate;
    

    public Address(){
        
    }
    /*public Date getLastUpDate() {
        return lastUpDate;
    }*/
    public Integer getAddresId() {
        return addresId;
    }
    public void setAddresId(Integer addresId) {
        this.addresId = addresId;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public int getCity() {
        return city;
    }
    public void setCity(int city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /*public void setLastUpDate(Date lastUpDate) {
        this.lastUpDate = lastUpDate;
    }*/
}
