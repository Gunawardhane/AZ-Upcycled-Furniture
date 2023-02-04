package lk.ijse.upcycled.to;

import java.util.ArrayList;

public class PlaceOrder {
    private String customerID;
    private String orderID;
    private ArrayList<CartDetails> orderDetails = new ArrayList<>();

    public PlaceOrder() {
    }

    public PlaceOrder(String customerID, String orderID, ArrayList<CartDetails> orderDetails) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDetails = orderDetails;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public ArrayList<CartDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "customerID='" + customerID + '\'' +
                ", orderID='" + orderID + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
