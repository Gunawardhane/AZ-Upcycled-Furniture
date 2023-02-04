package tm;

import javafx.scene.control.Button;

public class PlaceOrderTM {
    private String code;
    private String name;
    private int qty;
    private double unitPrice;
    private double total;
    private Button btnDelete;

    public PlaceOrderTM(String code, String name, int qty, double unitPrice, double total, Button btnDelete) {
        this.code = code;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        this.btnDelete = btnDelete;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "PlaceOrderTM{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                ", btnDelete=" + btnDelete +
                '}';
    }
}
