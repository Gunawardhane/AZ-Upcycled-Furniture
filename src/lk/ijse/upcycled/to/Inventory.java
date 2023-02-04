package lk.ijse.upcycled.to;

public class Inventory {
    private String ivID;
    private String QOH;
    private String SupID;
    private String ItemID;

    public Inventory(String ivID, String QOH, String supID, String itemID) {
        this.ivID = ivID;
        this.QOH = QOH;
        SupID = supID;
        ItemID = itemID;
    }

    public String getIvID() {
        return ivID;
    }

    public void setIvID(String ivID) {
        this.ivID = ivID;
    }

    public String getQOH() {
        return QOH;
    }

    public void setQOH(String QOH) {
        this.QOH = QOH;
    }

    public String getSupID() {
        return SupID;
    }

    public void setSupID(String supID) {
        SupID = supID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }
}
