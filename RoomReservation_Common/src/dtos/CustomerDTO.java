package dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    public CustomerDTO() {}

    public CustomerDTO(String nic, String customerName, int contact, String address) {
        this.nic = nic;
        this.customerName = customerName;
        this.contact = contact;
        Address = address;
    }

    private String nic;
    private String customerName;
    private int contact;
    private String Address;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}