package lk.ijse.upcycled.to;

public class CartDetails {
    private String orderID;
    private String code;
    private int qty;
    private String name;
    private double unitPrice;

    public CartDetails(String orderID, String code, int qty, String name, double unitPrice) {
        this.orderID = orderID;
        this.code = code;
        this.qty = qty;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
