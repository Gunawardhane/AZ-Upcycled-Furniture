package lk.ijse.upcycled.to;

import java.time.LocalDate;

public class CustomerOrder {
   private String customerOrderID;
   private LocalDate date;

    public CustomerOrder(String customerOrderID, LocalDate date, String customerID) {
        this.customerOrderID = customerOrderID;
        this.date = date;
        this.customerID = customerID;
    }

    private String customerID;

    public String getCustomerOrderID() {
        return customerOrderID;
    }

    public void setCustomerOrderID(String customerOrderID) {
        this.customerOrderID = customerOrderID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

}
