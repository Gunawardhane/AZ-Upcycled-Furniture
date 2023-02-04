package lk.ijse.upcycled.to;

public class Item {
           private String itemID;
           private String name;

    public Item(String itemID, String name, String unitPrice, String QOH) {
        this.itemID = itemID;
        this.name = name;
        this.unitPrice = unitPrice;
        this.QOH = QOH;
    }

    private String unitPrice;
           private String QOH;

    public Item() {
    }

    public Item(String code, String name, double unitPrice, int qty) {

    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQOH() {
        return QOH;
    }

    public void setQOH(String QOH) {
        this.QOH = QOH;
    }
}
